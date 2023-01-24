package com.example.spredpay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DonePaymentActivity extends AppCompatActivity {

    View done_deal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done_payment);

        done_deal = findViewById(R.id.done_button);

        done_deal.setOnClickListener(view -> {
            Intent newIntent = new Intent(DonePaymentActivity.this, CustomerMainActivity.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(newIntent);
        });
    }
}