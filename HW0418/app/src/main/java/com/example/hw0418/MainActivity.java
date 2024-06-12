package com.example.hw0418;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int sheet;
    TextView preview;
    String outputStr="";
    int total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preview=findViewById(R.id.tv_preview);
        Button btn_send=(Button) findViewById(R.id.send);
        EditText edt_sheet=(EditText)findViewById(R.id.edt_sheet);
        RadioButton male=(RadioButton) findViewById(R.id.rdb_male);
        RadioButton female=(RadioButton) findViewById(R.id.rdb_female);
        RadioGroup type=(RadioGroup) findViewById(R.id.rdg_ticket);

        // Add TextWatcher for EditText
        edt_sheet.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateOutputStr(male, female, type, edt_sheet);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        // Add OnCheckedChangeListener for RadioButtons
        male.setOnCheckedChangeListener((buttonView, isChecked) -> updateOutputStr(male, female, type, edt_sheet));
        female.setOnCheckedChangeListener((buttonView, isChecked) -> updateOutputStr(male, female, type, edt_sheet));
        type.setOnCheckedChangeListener((group, checkedId) -> updateOutputStr(male, female, type, edt_sheet));

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Second.class);
                intent.putExtra("bill",outputStr);
                startActivity(intent);
            }
        });
    }

    private void updateOutputStr(RadioButton male, RadioButton female, RadioGroup type, EditText edt_sheet) {
        outputStr = "";
        String sheetStr=edt_sheet.getText().toString();
        try {
            sheet=Integer.parseInt(sheetStr);
        } catch (NumberFormatException e) {
            sheet=0;
        }

        if(male.isChecked())
            outputStr +="男生\n";
        else if (female.isChecked()) {
            outputStr +="女生\n";
        }

        if(type.getCheckedRadioButtonId()==R.id.rdb_adult){
            outputStr+="成人票\n";
            total=sheet*500;
        }
        else if(type.getCheckedRadioButtonId()==R.id.rdb_child){
            outputStr+="孩童票\n";
            total=sheet*250;
        }
        else if(type.getCheckedRadioButtonId()==R.id.rdb_student){
            outputStr+="學生票\n";
            total=sheet*500;
        }
        outputStr+=sheet+"張\n";
        outputStr+=total+"元\n";
        preview.setText(outputStr);
    }
}