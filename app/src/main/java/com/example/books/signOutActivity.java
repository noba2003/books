package com.example.books;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signOutActivity extends AppCompatActivity {
    EditText signoutEmail, signoutrePassword, signoutPassword;
    Button signoutRegister, signoutCancel;
    private FirebaseAuth mAuth;
    String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_out);
        signoutEmail = findViewById(R.id.signout_email);
        signoutrePassword = findViewById(R.id.signout_rePassword3);
        signoutPassword = findViewById(R.id.signout_Password);
        signoutRegister = findViewById(R.id.register);
        signoutCancel = findViewById(R.id.signout_btn_cancel);

        mAuth = FirebaseAuth.getInstance();

        signoutRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = signoutEmail.getText().toString();
                password = signoutPassword.getText().toString();
                if (email.isEmpty()) {
                    signoutEmail.setError("enter email");
                    return;
                }
                if (password.isEmpty()) {
                    signoutPassword.setError("enter password");
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(signOutActivity.this, " Successful create email", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(signOutActivity.this,loginActivity.class);
                            startActivity(intent);

                        } else {
                            Toast.makeText(signOutActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });


    }
}