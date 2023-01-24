package com.example.spredpay;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ChooseCardActivity extends AppCompatActivity {

    ImageView imageViewCard, ic_arrow_back, faceid, hold_near;
    TextView textViewBank, textViewCrypto, textViewSpred, textPayment, textPaymentBalance;
    View viewBank, viewCrypto, viewSpred;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_card);

        imageViewCard = findViewById(R.id.imageview_card);

        textViewBank = findViewById(R.id.tv_bank);
        textViewCrypto = findViewById(R.id.tv_crypto);
        textViewSpred = findViewById(R.id.tv_spred);

        viewBank = findViewById(R.id.view_bank);
        viewCrypto = findViewById(R.id.view_crypto);
        viewSpred = findViewById(R.id.view_spred);

        textPayment = findViewById(R.id.text_payment);
        textPaymentBalance = findViewById(R.id.text_payment_balance);

        hold_near = findViewById(R.id.imageView_hold_near);
        faceid = findViewById(R.id.imageView_double_faceID);
        ic_arrow_back = findViewById(R.id.ic_arrow_back);

        textViewBank.setOnClickListener(view -> {
            viewBank.setVisibility(View.VISIBLE);
            viewCrypto.setVisibility(View.INVISIBLE);
            viewSpred.setVisibility(View.INVISIBLE);

            imageViewCard.setImageResource(R.drawable.img_bank_card);
            textPayment.setText("Revolut");
            textPaymentBalance.setText("Show balance");
        });

        textViewCrypto.setOnClickListener(view -> {
            viewBank.setVisibility(View.INVISIBLE);
            viewCrypto.setVisibility(View.VISIBLE);
            viewSpred.setVisibility(View.INVISIBLE);

            imageViewCard.setImageResource(R.drawable.img_crypto_card);
            textPayment.setText("Solana");
            textPaymentBalance.setText("Show balance");
        });

        textViewSpred.setOnClickListener(view -> {
            viewBank.setVisibility(View.INVISIBLE);
            viewCrypto.setVisibility(View.INVISIBLE);
            viewSpred.setVisibility(View.VISIBLE);

            imageViewCard.setImageResource(R.drawable.img_spred_card);
            textPayment.setText("Spred Coin");
            textPaymentBalance.setText("Show balance");
        });

        textPaymentBalance.setOnClickListener(view -> {
            if(textPaymentBalance.getText().toString().equals("Show balance")) {
                if(textPayment.getText().toString().equals("Revolut")) {
                    textPaymentBalance.setText("300 €");
                }
                else if(textPayment.getText().toString().equals("Solana")) {
                    textPaymentBalance.setText("99.01 €");
                }
                else if(textPayment.getText().toString().equals("Spred Coin")) {
                    textPaymentBalance.setText("1 000 €");
                }
            }
            else {
                textPaymentBalance.setText("Show balance");
            }
        });

        faceid.setOnClickListener(view -> {
            faceid.setVisibility(View.INVISIBLE);
            hold_near.setVisibility(View.VISIBLE);
        });

        hold_near.setOnClickListener(view -> {
            Intent newIntent = new Intent(ChooseCardActivity.this, DonePaymentActivity.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(newIntent);
        });

        ic_arrow_back.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(ChooseCardActivity.this);
            builder.setTitle("Payment cancellation");
            builder.setIcon(R.drawable.logo_top);
            builder.setMessage("Are you sure you want to abort the payment process?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Intent newIntent = new Intent(ChooseCardActivity.this, CustomerMainActivity.class);
                            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            newIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(newIntent);
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    });
            AlertDialog alert = builder.create();
            alert.setOnShowListener(new DialogInterface.OnShowListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onShow(DialogInterface arg0) {
                    alert.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.parseColor("#1C1B1F"));
                    alert.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.parseColor("#1C1B1F"));
                }
            });
            alert.show();
        });
    }

    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ChooseCardActivity.this);
        builder.setTitle("Payment cancellation");
        builder.setIcon(R.drawable.logo_top);
        builder.setMessage("Are you sure you want to abort the payment process?")
                .setCancelable(false)
                .setPositiveButton("Yes", (dialog, id) -> {
                    Intent newIntent = new Intent(ChooseCardActivity.this, CustomerMainActivity.class);
                    newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    newIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(newIntent);
                })
                .setNegativeButton("No", (dialog, id) -> {

                });
        AlertDialog alert = builder.create();
        alert.setOnShowListener(arg0 -> {
            alert.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.parseColor("#0044FF"));
            alert.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.parseColor("#0044FF"));
        });
        alert.show();
    }
}