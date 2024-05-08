package com.example.hw0502;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    ImageView img_burger,img_fries,img_coffee,img_drink,img_soup;
    private CheckBox burger,fries,coffee,softdrink,soup;
    private int[] chkfood = {R.id.chkburger,R.id.chkfries,R.id.chkcoffee,R.id.chkdrink,R.id.chksoup};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            burger=findViewById(R.id.chkburger);
            fries=findViewById(R.id.chkfries);
            coffee=findViewById(R.id.chkcoffee);
            softdrink=findViewById(R.id.chkdrink);
            soup=findViewById(R.id.chksoup);

            img_burger=findViewById(R.id.output1);
            img_coffee=findViewById(R.id.output2);
            img_fries=findViewById(R.id.output3);
            img_drink=findViewById(R.id.output4);
            img_soup=findViewById(R.id.output5);

            for(int id:chkfood){
                CheckBox chk=(CheckBox) findViewById(id);
                chk.setOnCheckedChangeListener(this);
            }
    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

        int id=compoundButton.getId();
        if(id==R.id.chkburger){
            if(isChecked){
                img_burger.setVisibility(View.VISIBLE);
            }
            else {
                img_burger.setVisibility(View.INVISIBLE);
            }
        }
        if(id==R.id.chkfries){
            if(isChecked){
                img_fries.setVisibility(View.VISIBLE);
            }
            else{
                img_fries.setVisibility(View.INVISIBLE);
            }
        }
        if(id==R.id.chkcoffee) {
            if (isChecked) {
                img_coffee.setVisibility(View.VISIBLE);
            } else {
                img_coffee.setVisibility(View.INVISIBLE);
            }
        }
        if(id==R.id.chkdrink){
            if(isChecked){
                img_drink.setVisibility(View.VISIBLE);
            }
            else{
                img_drink.setVisibility(View.INVISIBLE);
            }
        }
        if(id==R.id.chksoup) {
            if (isChecked) {
                img_soup.setVisibility(View.VISIBLE);
            } else {
                img_soup.setVisibility(View.INVISIBLE);
            }
        }
    }
}