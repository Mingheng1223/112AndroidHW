package com.example.spandlv;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    ListView listView;
    TextView tv_main,tv_sub,tv_drink;
    String[] main  = { "牛肉漢堡","豬肉漢堡","炸雞漢堡","炸魚漢堡" };
    String[] sub   = { "薯條","薯餅","薯條+薯餅","沙拉" };
    String[] drink = { "可樂","雪碧","檸檬紅茶","綠茶","奶茶","紅茶","咖啡" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner= findViewById(R.id.spinner);
        listView= findViewById(R.id.listView);

        tv_main= findViewById(R.id.txt_order1);
        tv_sub= findViewById(R.id.txt_order2);
        tv_drink= findViewById(R.id.txt_order3);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] menuSet;
                if(position==0)
                    menuSet=main;
                else if(position==1)
                    menuSet=sub;
                else
                    menuSet=drink;

                ArrayAdapter<String> menuAdapter = new ArrayAdapter<>(MainActivity.this,
                        android.R.layout.simple_spinner_item, menuSet);
                listView.setAdapter(menuAdapter);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);

                // 根據 spinner 的選擇來決定要更新哪個 TextView
                int spinnerPosition = spinner.getSelectedItemPosition();
                switch (spinnerPosition) {
                    case 0:
                        tv_main.setText(selectedItem);
                        break;
                    case 1:
                        tv_sub.setText(selectedItem);
                        break;
                    case 2:
                        tv_drink.setText(selectedItem);
                        break;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.clear){
            tv_main.setText("");
            tv_sub.setText("");
            tv_drink.setText("");
        }
        if(item.getItemId()==R.id.send){
            String order = tv_main.getText().toString() + "\n" +
                    tv_sub.getText().toString() + "\n" +
                    tv_drink.getText().toString();
            Intent intent = new Intent(MainActivity.this, Second.class);
            intent.putExtra("order", order);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
