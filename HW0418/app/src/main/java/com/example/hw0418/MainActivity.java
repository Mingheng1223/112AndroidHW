package com.example.hw0418;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int sheet;
    String outputStr="";
    int total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_send=(Button) findViewById(R.id.send);
        EditText edt_sheet=(EditText)findViewById(R.id.edt_sheet);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sheet=Integer.parseInt(edt_sheet.getText().toString());

                RadioButton male=(RadioButton) findViewById(R.id.rdb_male);
                RadioButton female=(RadioButton) findViewById(R.id.rdb_female);
                if(male.isChecked())
                    outputStr +="男生\n";
                else if (female.isChecked()) {
                    outputStr +="女生\n";
                }
                RadioGroup type=(RadioGroup) findViewById(R.id.rdg_ticket);
                if(type.getCheckedRadioButtonId()==R.id.rdb_adult){
                    outputStr+="成人票\n";
                    total=sheet*500;
                }
                else
                    if(type.getCheckedRadioButtonId()==R.id.rdb_child){
                    outputStr+="孩童票\n";
                    total=sheet*250;
                }
                else if(type.getCheckedRadioButtonId()==R.id.rdb_student){
                    outputStr+="學生票\n";
                    total=sheet*500;
                }
                outputStr+=sheet+"張\n";
                outputStr+=total+"元\n";

                Intent intent=new Intent(MainActivity.this,Second.class);
                intent.putExtra("bill",outputStr);
                startActivity(intent);
            }
//            TextView preview=findViewById(R.id.tv_preview);
//                preview.setText(outputStr);
        });
    }
}