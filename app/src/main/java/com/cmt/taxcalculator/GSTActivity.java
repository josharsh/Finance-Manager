package com.cmt.taxcalculator;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.cmt.taxcalculator.databinding.ActivityEmiBinding;

public class GSTActivity extends AppCompatActivity {
private ActivityEmiBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding=ActivityEmiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}

