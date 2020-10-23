package com.example.books;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.books.MainActivity;
import com.example.books.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText email, password;
    Button signIn, signOut;
    String loginEmail, loginPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.login_txt_email);
        password = findViewById(R.id.login_txt_password);
        signIn = findViewById(R.id.signin_login);
        signOut = findViewById(R.id.signout_login);


        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginEmail = email.getText().toString();
                loginPassword = password.getText().toString();
                if (loginEmail.isEmpty()) {
                    email.setError("enter correct email");
                    return;
                }
                if (loginPassword.isEmpty()) {
                    password.setError("enter correct email");
                    return;
                }
                mAuth.signInWithEmailAndPassword(loginEmail, loginPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(loginActivity.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(loginActivity.this, "faild " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginActivity.this, signOutActivity.class);
                startActivity(intent);
            }
        });


    }
}