package com.cmt.taxcalculator;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.cmt.taxcalculator.databinding.ActivityIncomeBinding;


public class IncomeActivity extends AppCompatActivity {

    EditText bs;
    EditText hra;
    EditText sa;
    EditText lta;
    TextView T1, T2, T3, T4, T5;
    TextView tx;
    TextView tx1;
    Button b1;
    Button con;
    private ActivityIncomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIncomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        con = binding.next;
        bs = binding.edit1;
        hra = binding.edit2;
        sa = binding.edit3;
        lta = binding.edit4;
        T1 = binding.t1;
        T2 = binding.t2;
        T3 = binding.t3;
        T4 = binding.t4;
        T5 = binding.t5;


        tx1 = binding.text3;
        b1 = binding.go;
        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    int HRA = Integer.parseInt(String.valueOf(hra.getText().toString().equals("") ? "0" : hra.getText()));
                    int LTAc = Integer.parseInt(String.valueOf(lta.getText().toString().equals("") ? "0" : lta.getText()));

                    double calcHRA = 0.36 * HRA;
                    double calcLTA = 0.12 * LTAc;

                    T1.setText((String.valueOf(bs.getText().toString().equals("") ? "0.0" : bs.getText())));
                    T2.setText(String.valueOf(calcHRA));
                    T3.setText(String.valueOf(sa.getText().toString().equals("") ? "0.0" : sa.getText()));
                    T4.setText(String.valueOf(calcLTA));
                    T5.setText(String.valueOf(50000));
                    con.setEnabled(true);

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();

                }
            }
        });
    }


    public void calculate() {
        Intent i = new Intent(IncomeActivity.this, NextIncome.class);
        i.putExtra("baseincome", bs.getText().toString());
        i.putExtra("HRA", T2.getText().toString());
        i.putExtra("SA", sa.getText().toString());
        i.putExtra("LTA", lta.getText().toString());
        startActivity(i);

    }
}