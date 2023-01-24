package com.example.spredpay;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SettingsFragment extends Fragment {

    public View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_settings, container, false);

        Button button_crypto = (Button) view.findViewById(R.id.crypto_settings);
        button_crypto.setOnClickListener(v -> {
            cryptoSettingsActivity();
        });

        return view;
    }

    private void cryptoSettingsActivity() {
        Intent intent = new Intent(getActivity(), CryptoSettings.class);
        startActivity(intent);
    }
}