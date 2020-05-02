package com.cmt.taxcalculator;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView t;
    Button b1;
    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);// To Display The Layout from activy_main resource layout file. 
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, com.cmt.taxcalculator.IncomeActivity.class);
                startActivity(intent); // On clicking on the button, Income Tax Calculator activity is called
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, com.cmt.taxcalculator.EMIActivity.class);
                startActivity(intent);// On clicking on the button, EMI activity is called
            }
        });
    }

    public void exitApp() {
        finish();
    }

}
