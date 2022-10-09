package com.cmt.taxcalculator;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.cmt.taxcalculator.databinding.ActivityEmiBinding;


public class EMIActivity extends AppCompatActivity {

    Button emiCalcBtn;
    private ActivityEmiBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEmiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final EditText P = binding.principal;
        final EditText I = binding.interest;
        final EditText Y = binding.years;
        final EditText TI = binding.interestTotal;
        final EditText result = binding.emi;


        emiCalcBtn = binding.btnCalculate2;

        emiCalcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String st1 = P.getText().toString();
                String st2 = I.getText().toString();
                String st3 = Y.getText().toString();

                if (TextUtils.isEmpty(st1)) {
                    P.setError("Enter Principal Amount");
                    P.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(st2)) {
                    I.setError("Enter Interest Rate");
                    I.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(st3)) {
                    Y.setError("Enter Years");
                    Y.requestFocus();
                    return;
                }

                float p = Float.parseFloat(st1);
                float i = Float.parseFloat(st2);
                float y = Float.parseFloat(st3);

                float Principal = calPric(p);

                float Rate = calInt(i);

                float Months = calMonth(y);

                float Dvdnt = calDvdnt(Rate, Months);

                float FD = calFinalDvdnt(Principal, Rate, Dvdnt);

                float D = calDivider(Dvdnt);

                float emi = calEmi(FD, D);

                float TA = calTa(emi, Months);

                float ti = calTotalInt(TA, Principal);

                result.setText(String.valueOf(emi));

                TI.setText(String.valueOf(ti));

            }
        });
    }

    public float calPric(float p) {

        return (p);

    }

    public float calInt(float i) {

        return (i / 12 / 100);

    }

    public float calMonth(float y) {

        return (y * 12);

    }

    public float calDvdnt(float Rate, float Months) {

        return (float) ((1 + Rate) * Months);

    }

    public float calFinalDvdnt(float Principal, float Rate, float Dvdnt) {

        return (Principal * Rate * Dvdnt);

    }

    public float calDivider(float Dvdnt) {

        return (Dvdnt - 1);

    }

    public float calEmi(float FD, Float D) {

        return (FD / D);

    }

    public float calTa(float emi, Float Months) {

        return (emi * Months);

    }

    public float calTotalInt(float TA, float Principal) {

        return (Math.abs(TA - Principal));

    }
}
