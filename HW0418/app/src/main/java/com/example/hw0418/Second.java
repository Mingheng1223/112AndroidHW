package com.example.hw0418;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView result=findViewById(R.id.tv_result);
        Intent intent=getIntent();
        String str=intent.getStringExtra("bill");
        result.setText(str);
    }
}