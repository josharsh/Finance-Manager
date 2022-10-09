package com.cmt.taxcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.cmt.taxcalculator.databinding.ActivityNextIncomeBinding;


public class NextIncome extends AppCompatActivity {
    Button go;
    EditText e1, e2, e3;
    String base, LTA, HRA, SA;

    private ActivityNextIncomeBinding binding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNextIncomeBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        e1 = binding.edit1;

        e2 = binding.edit2;

        e3 = binding.edit3;
        Intent i = getIntent();
        base = i.getStringExtra("baseincome");
        LTA = i.getStringExtra("LTA");
        HRA = i.getStringExtra("HRA");
        SA = i.getStringExtra("SA");

        go = binding.go;
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    public void finish() {
        double A = Double.parseDouble(String.valueOf(e1.getText().toString().equals("") ? "0.0" : e1.getText()));
        double B = Double.parseDouble(String.valueOf(e2.getText().toString().equals("") ? "0.0" : e2.getText()));
        double C = Double.parseDouble(String.valueOf(e3.getText().toString().equals("") ? "0.0" : e3.getText()));
        System.out.println(A + " " + B + " " + C);
        Intent i = new Intent(NextIncome.this, FinalIncomeActivity.class);
        i.putExtra("80A", e1.getText().toString());
        i.putExtra("base", base);
        i.putExtra("hra", HRA);
        i.putExtra("lta", LTA);
        i.putExtra("sa", SA);
        i.putExtra("80B", e2.getText().toString());
        i.putExtra("80C", e3.getText().toString());
        startActivity(i);

    }


}
