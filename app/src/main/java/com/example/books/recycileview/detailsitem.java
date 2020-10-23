package com.example.books.recycileview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.books.R;

public class detailsitem extends AppCompatActivity {
TextView title,detils;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailsitem);
        title=findViewById(R.id.textView);
        detils=findViewById(R.id.textView2);
 String ti=   getIntent().getStringExtra("a");
        String de=  getIntent().getStringExtra("b");

        title.setText(ti);
        detils.setText(de);
    }
}