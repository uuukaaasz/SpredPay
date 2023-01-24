package com.example.spredpay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class TerminalPaymentActivity extends AppCompatActivity {

    ImageView hold_near_merchant;
    TextView amount_to_pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terminal_payment);

        hold_near_merchant = findViewById(R.id.hold_near_merchant);
        amount_to_pay = findViewById(R.id.terminal_edittext);

        hold_near_merchant.setOnClickListener(view -> {
            Intent intent = new Intent(this, MerchantDoneActivity.class);
            startActivity(intent);
        });

        String amount = ((GlobalVariables) this.getApplication()).getAmount();
        amount_to_pay.setText(amount +" €");
    }
}