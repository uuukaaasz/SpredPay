package com.example.spredpay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class CryptoSettings extends AppCompatActivity {

    TextView totalBalanceValue, btc, eth, sol, xrp, bnb, doge;

    public double total = 0;
    String s_btc, s_eth, s_sol, s_xrp, s_bnb, s_doge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crypto_settings);

        totalBalanceValue = findViewById(R.id.home_totalBalanceValue);
        btc = findViewById(R.id.bitcoin_amount);
        eth = findViewById(R.id.ethereum_amount);
        sol = findViewById(R.id.solana_amount);
        xrp = findViewById(R.id.ripple_amount);
        bnb = findViewById(R.id.bnb_amount);
        doge = findViewById(R.id.doge_amount);

        s_btc = remove_currency(btc.getText().toString());
        s_eth = remove_currency(eth.getText().toString());
        s_sol = remove_currency(sol.getText().toString());
        s_xrp = remove_currency(xrp.getText().toString());
        s_bnb = remove_currency(bnb.getText().toString());
        s_doge = remove_currency(doge.getText().toString());

        try {
            double d_btc = Double.parseDouble(s_btc);
            double d_eth = Double.parseDouble(s_eth);
            double d_sol = Double.parseDouble(s_sol);
            double d_xrp = Double.parseDouble(s_xrp);
            double d_bnb = Double.parseDouble(s_bnb);
            double d_doge = Double.parseDouble(s_doge);
            total = d_btc + d_eth + d_sol + d_xrp + d_bnb + d_doge;
            totalBalanceValue.setText(total+" €");
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Cannot read values '"+ s_btc + "'", Toast.LENGTH_SHORT).show();
        }
    }

    public String remove_currency(String str) {
        if (str != null && str.length() > 0) {
            str = str.substring(0, str.length() - 2);
        }
        return str;
    }
}