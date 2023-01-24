package com.example.spredpay;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FaceIdPinActivity extends AppCompatActivity {

    EditText pinview;
    ImageView imageView_faceID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face_id_pin);

        imageView_faceID = findViewById(R.id.faceID_faceId);
        pinview = findViewById(R.id.pinView);

        getinfoJSON();

        imageView_faceID.setOnClickListener(view -> {
            imageView_faceID.setImageResource(R.drawable.faceid_login_success);
            Handler handler = new Handler();
            handler.postDelayed(() -> startActivity(new Intent(FaceIdPinActivity.this, CustomerMainActivity.class)), 500);
        });

        pinview.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }
            @Override
            public void afterTextChanged(Editable text) {
                // TODO Auto-generated method stub
                if (text.length() == 6) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                    if (text.toString().equals("123456")) {
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(new Intent(FaceIdPinActivity.this, CustomerMainActivity.class));
                            }
                        }, 0);
                    }
                    else if (text.toString().equals("135790")) {
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(new Intent(FaceIdPinActivity.this, MerchantMainActivity.class));
                            }
                        }, 0);
                    }
                    else {
                        toastWrongPIN();
                        pinview.setText("");
                    }
                }
            }
        });

    }

    private void getinfoJSON() {
        ((GlobalVariables) this.getApplication()).getJSON();
    }

    private void toastWrongPIN() {
        Toast.makeText(this, "Wrong PIN code, try again", Toast.LENGTH_SHORT).show();
    }

}
