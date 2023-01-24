package com.example.spredpay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MerchantDoneActivity extends AppCompatActivity {

    View merchant_done_button, terminal_back_button;
    TextView done_balance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant_done);

        merchant_done_button = findViewById(R.id.merchant_done_button);
        terminal_back_button = findViewById(R.id.terminal_back_button);
        done_balance = findViewById(R.id.done_balance);

        String amount = ((GlobalVariables) this.getApplication()).getAmount();
        done_balance.setText(amount +" €");

        merchant_done_button.setOnClickListener(view -> {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(MerchantDoneActivity.this, MerchantMainActivity.class));
                }
            }, 500);
        });

        terminal_back_button.setOnClickListener(view -> {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(MerchantDoneActivity.this, TerminalTypeAmountActivity.class));
                }
            }, 500);
        });
    }
}