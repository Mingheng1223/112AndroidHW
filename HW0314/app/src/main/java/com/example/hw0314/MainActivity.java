package com.example.hw0314;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    String User = "Shumis2024";
    String PassWord = "az03140314";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn_send(View view) {
        EditText Edituser = findViewById(R.id.EditUser);
        EditText Editpw = findViewById(R.id.EditPw);
        TextView TxtResult = findViewById(R.id.TextResult);
        String inputuser = Edituser.getText().toString();
        String inputpw = Editpw.getText().toString();
        if(inputuser.isEmpty()){
            TxtResult.setText(R.string.nulluser);
        } else if (inputpw.isEmpty()) {
            TxtResult.setText(R.string.nullpassword);
        } else  if (!Objects.equals(User, inputuser)) {
            TxtResult.setText(R.string.erroruser);
        } else if (!Objects.equals(PassWord, inputpw)) {
            TxtResult.setText(R.string.errorpassword);
        } else {
            TxtResult.setText(R.string.success);
        }

    }
}