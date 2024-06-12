package com.example.spandlv;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;


public class Second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView result=findViewById(R.id.textView);
        Intent intent=getIntent();
        String order=intent.getStringExtra("order");
        result.setText(order);

    }
}