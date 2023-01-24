package com.example.spredpay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText username, password;
    Button buttonLogin;
    TextView goToRegister;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.log_username);
        password = findViewById(R.id.log_password);
        buttonLogin = findViewById(R.id.button_Login);
        goToRegister = findViewById(R.id.goToRegister);
        progressBar = findViewById(R.id.log_progressBar);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s_username, s_password;
                s_username = String.valueOf(username.getText());
                s_password = String.valueOf(password.getText());

                if(!s_username.equals("") && !s_password.equals("")) {
                    progressBar.setVisibility(View.VISIBLE);

                    Intent intent = new Intent(getApplicationContext(), CustomerMainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Wszystkie pola są wymagane", Toast.LENGTH_LONG).show();
                }
            }
        });

        goToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void loginSetUsername(){
        String set_username = String.valueOf(username.getText());
        ((GlobalVariables) this.getApplicationContext()).setUsername(set_username);
    }
}