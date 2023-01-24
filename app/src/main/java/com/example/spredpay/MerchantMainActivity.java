package com.example.spredpay;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MerchantMainActivity extends AppCompatActivity {

    View terminal_button;
    TextView textviewTerminal;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant_main);

        terminal_button = findViewById(R.id.terminal_button);
        textviewTerminal = findViewById(R.id.textview_terminal);

        terminal_button.setOnClickListener(view -> {
            terminal_button.setBackgroundResource(R.drawable.terminal_button2);
            textviewTerminal.setTextColor(Color.WHITE);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    terminal_button.setBackgroundResource(R.drawable.ic_done_button);
                    textviewTerminal.setTextColor(Color.BLACK);
                    Intent intent = new Intent(MerchantMainActivity.this, TerminalTypeAmountActivity.class);
                    startActivity(intent);
                }
            }, 200);
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListenerMerchant);

        View view = bottomNavigationView.findViewById(R.id.homeMerchantFragment);
        view.performClick();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListenerMerchant =
            item -> {
                Fragment selectedFragment = null;

                switch (item.getItemId()) {
                    case R.id.homeMerchantFragment:
                        selectedFragment = new Fragment();
                        break;
                    case R.id.transferFragment:
                        selectedFragment = new TransferFragment();
                        break;
                    case R.id.settingsFragment:
                        selectedFragment = new SettingsFragment();
                        break;
                }
                assert selectedFragment != null;
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                return true;
            };
}