package com.example.spredpay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class SignUpActivity extends AppCompatActivity {

    TextInputEditText username, email, password, confirm_password;
    Button buttonRegister;
    TextView goToLogin;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username = findViewById(R.id.reg_username);
        email = findViewById(R.id.reg_email);
        password = findViewById(R.id.reg_password);
        confirm_password = findViewById(R.id.reg_confirm_password);
        buttonRegister = findViewById(R.id.button_register);
        goToLogin = findViewById(R.id.goToLogin);
        progressBar = findViewById(R.id.reg_progressBar);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s_username, s_email, s_password, s_confirm_password;
                s_username = String.valueOf(username.getText());
                s_email = String.valueOf(email.getText());
                s_password = String.valueOf(password.getText());
                s_confirm_password = String.valueOf(confirm_password.getText());

                if(!s_username.equals("") && !s_email.equals("") && !s_password.equals("") && !s_confirm_password.equals("")) {
                    if(s_password.equals(s_confirm_password)) {
                        progressBar.setVisibility(View.VISIBLE);
                        Toast.makeText(getApplicationContext(), "Zarejestrowano pomyślnie!", Toast.LENGTH_LONG).show();
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        }, 1000);
                    } else {
                        Toast.makeText(getApplicationContext(), "Hasła nie są identyczne", Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Wszystkie pola są wymagane", Toast.LENGTH_LONG).show();
                }
            }
        });

        goToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}