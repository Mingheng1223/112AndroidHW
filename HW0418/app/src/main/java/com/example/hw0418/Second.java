package com.example.hw0418;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Second extends AppCompatActivity {
    TextView result;
    String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        result=findViewById(R.id.tv_result);

        Intent intent=getIntent();
        str=intent.getStringExtra("bill");
        result.setText("您的訂票資訊\n"+str);

    }
}