package com.example.spredpay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;

public class SwapActivity extends AppCompatActivity {

    Spinner spinner, spinner2;
    SpinnerAdapter spinnerAdapter;
    String[] names = {"EUR", "BTC", "SPD"};
    int[] images = {R.drawable.ic_home_bank, R.drawable.ic_home_crypto, R.drawable.ic_home_spred};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swap);

        spinner = findViewById(R.id.spinner);
        spinner2 = findViewById(R.id.spinner2);

        spinnerAdapter = new SpinnerAdapter(this, names, images);

        spinner.setAdapter(spinnerAdapter);
        spinner2.setAdapter(spinnerAdapter);
    }
}