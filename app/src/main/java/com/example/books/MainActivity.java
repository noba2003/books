package com.example.books;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.books.recycileview.adapterCourse;
import com.example.books.recycileview.callbackSendData;
import com.example.books.recycileview.detailsitem;
import com.example.books.recycileview.item;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    public com.example.books.recycileview.callbackSendData callbackSendData;
    RecyclerView recyclerView;
    List<item> listbook;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
      mAuth.signOut();
        if (mAuth == null) {
           Intent intent=new Intent(MainActivity.this,loginActivity.class);

           startActivity(intent);
        }
        listbook = new ArrayList<item>();
        myRef = FirebaseDatabase.getInstance().getReference().child("android/lesson");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot Snapshot1 : snapshot.getChildren()) {
                    item value = Snapshot1.getValue(item.class);
                    listbook.add(value);

                }
                callbackSendData=new callbackSendData() {
                    @Override
                    public void sendDataToActiviat(int position) {
                        Intent intent=new Intent(MainActivity.this, detailsitem.class);
                        intent.putExtra("a",listbook.get(position).getLessonTiltle());
                        intent.putExtra("b",listbook.get(position).getAuthor());
                       startActivity(intent);
                    }


                };

                recyclerView=findViewById(R.id.recyclerview);
                recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,2,RecyclerView.VERTICAL,false));
                recyclerView.setAdapter(new adapterCourse(listbook,MainActivity.this,callbackSendData));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}