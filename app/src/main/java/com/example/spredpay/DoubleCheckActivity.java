package com.example.spredpay;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.chaos.view.PinView;

public class DoubleCheckActivity extends AppCompatActivity {

    PinView pinview;
    ImageView imageViewfaceID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_double_check);

        pinview = findViewById(R.id.double_pinView);
        imageViewfaceID = findViewById(R.id.imageView_double_faceID);

        imageViewfaceID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "Face ID recognized!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(DoubleCheckActivity.this, ChooseCardActivity.class));
                    }
                }, 100);
            }
        });

        pinview.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().length() == 4) {
                    if (charSequence.toString().equals("1234")) {
                        Toast.makeText(getApplicationContext(), "Successfully log in!", Toast.LENGTH_SHORT).show();

                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(new Intent(DoubleCheckActivity.this, ChooseCardActivity.class));
                            }
                        }, 100);
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Error! Incorrect PIN!", Toast.LENGTH_SHORT).show();
                        pinview.setText(null);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) { }
        });
    }
}