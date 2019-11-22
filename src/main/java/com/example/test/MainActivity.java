package com.example.test;


import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button button_check,button_next;
    TextView num1, num2, check;
    EditText res;
    int random1, random2;
    protected void aufgabeGen (){

        do {
            random1 = new Random().nextInt(8)+2;//int range 2-9
            random2 = new Random().nextInt(8)+2;//int range 2-9
        }while (random1 == random2);

        num1.setText(Integer.toString(random1));
        num2.setText(Integer.toString(random2));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        res = findViewById(R.id.editText);
        button_check = findViewById(R.id.button_check);
        button_next = findViewById(R.id.next);

        aufgabeGen();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void werten(View view) {
        int ein;
        try {
            ein = Integer.parseInt(res.getText().toString());
            check = findViewById(R.id.CheckText);
            if (ein == (random1 * random2)) {
                check.setText("Richtig :) " );
                button_next.setVisibility(View.VISIBLE);

            } else {
                res.setText("" );
                check.setText("versuch's erneut ;)" );
            }
        }catch (Exception e){
        Toast.makeText(getApplicationContext(),"du musst zuerst etwas eingeben  ",Toast.LENGTH_LONG).show();
    }

    }

    public void next(View view) {
            button_next.setVisibility(View.INVISIBLE);
            aufgabeGen();
            res.setText("");
            check.setText("");

    }
}
