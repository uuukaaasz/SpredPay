package com.example.spredpay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class TerminalTypeAmountActivity extends AppCompatActivity {

    TextView editTextTerminal;
    Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt0, btcomma, btConfirm, btcorrect;

    public int i = 1;
    public int dec = 0;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terminal_type_amount);

        editTextTerminal = findViewById(R.id.terminal_edittext);
        bt1 = findViewById(R.id.terminal_1);
        bt2 = findViewById(R.id.terminal_2);
        bt3 = findViewById(R.id.terminal_3);
        bt4 = findViewById(R.id.terminal_4);
        bt5 = findViewById(R.id.terminal_5);
        bt6 = findViewById(R.id.terminal_6);
        bt7 = findViewById(R.id.terminal_7);
        bt8 = findViewById(R.id.terminal_8);
        bt9 = findViewById(R.id.terminal_9);
        bt0 = findViewById(R.id.terminal_0);
        btcorrect = findViewById(R.id.terminal_correct);
        btcomma = findViewById(R.id.terminal_coma);
        btConfirm = findViewById(R.id.terminal_confirm);

        btConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLocalAmount();
                Intent intent = new Intent(TerminalTypeAmountActivity.this, TerminalPaymentActivity.class);
                startActivity(intent);
            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAmount("1");
                bt1.setBackgroundColor(Color.rgb(221,221,221));
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        bt1.setBackgroundColor(Color.WHITE);
                    }
                }, 300);
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAmount("2");
                bt2.setBackgroundColor(Color.rgb(221,221,221));
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        bt2.setBackgroundColor(Color.WHITE);
                    }
                }, 300);
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAmount("3");
                bt3.setBackgroundColor(Color.rgb(221,221,221));
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        bt3.setBackgroundColor(Color.WHITE);
                    }
                }, 300);
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAmount("4");
                bt4.setBackgroundColor(Color.rgb(221,221,221));
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        bt4.setBackgroundColor(Color.WHITE);
                    }
                }, 300);
            }
        });

        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAmount("5");
                bt5.setBackgroundColor(Color.rgb(221,221,221));
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        bt5.setBackgroundColor(Color.WHITE);
                    }
                }, 300);
            }
        });

        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAmount("6");
                bt6.setBackgroundColor(Color.rgb(221,221,221));
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        bt6.setBackgroundColor(Color.WHITE);
                    }
                }, 300);
            }
        });

        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAmount("7");
                bt7.setBackgroundColor(Color.rgb(221,221,221));
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        bt7.setBackgroundColor(Color.WHITE);
                    }
                }, 300);
            }
        });

        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAmount("8");
                bt8.setBackgroundColor(Color.rgb(221,221,221));
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        bt8.setBackgroundColor(Color.WHITE);
                    }
                }, 300);
            }
        });

        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAmount("9");
                bt9.setBackgroundColor(Color.rgb(221,221,221));
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        bt9.setBackgroundColor(Color.WHITE);
                    }
                }, 300);
            }
        });

        bt0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAmount("0");
                bt0.setBackgroundColor(Color.rgb(221,221,221));
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        bt0.setBackgroundColor(Color.WHITE);
                    }
                }, 300);
            }
        });

        btcomma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dec == 0) { dec = 1; }
                btcomma.setBackgroundColor(Color.rgb(221,221,221));
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btcomma.setBackgroundColor(Color.WHITE);
                    }
                }, 300);
            }
        });

        btcorrect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String word = editTextTerminal.getText().toString();
                int input = word.length();
                if (input > 0){
                    editTextTerminal.setText("0,00");
                    i = 1;
                    dec = 0;
                    btConfirm.setBackgroundColor(Color.rgb(235,235,235));
                }
            }
        });
    }

    private void setAmount(String buttonNumber) {
        if (dec == 0) {
            if (i < 10) {
                String word = editTextTerminal.getText().toString();
                int input = word.length();
                if (input > 0){
                    String w_suffix = word.substring(input-2, input);
                    String w_prefix = word.substring(0, input-3);
                    if (w_prefix.equals("0")) {
                        editTextTerminal.setText(buttonNumber+","+w_suffix);
                    } else {
                        w_prefix = w_prefix + buttonNumber;
                        editTextTerminal.setText(w_prefix+","+w_suffix);
                    }
                    i++;
                    if(i > 1) {
                        btConfirm.setBackgroundColor(Color.rgb(0,240,185));
                    }
                }
            } else {
                Toast.makeText(this, "This is the maximum number of digits allowed!", Toast.LENGTH_SHORT).show();
            }
        } else {
            setDecimal(buttonNumber);
        }
    }

    private void setDecimal(String buttonNumber) {
        if (dec < 3) {
            String word = editTextTerminal.getText().toString();
            int input = word.length();
            if (input > 0) {
                String w_suffix = word.substring(input - dec, input);
                String w_prefix = word.substring(0, input - 3);
                if (dec == 1) {
                    editTextTerminal.setText(w_prefix+",0"+ buttonNumber);
                } else if (dec == 2) {
                    w_suffix = w_suffix.substring(1, 2);
                    w_suffix = w_suffix + buttonNumber;
                    editTextTerminal.setText(w_prefix + "," + w_suffix);
                }
                if (dec == 1 || dec == 2) {
                    dec++;
                    btConfirm.setBackgroundColor(Color.rgb(0, 240, 185));
                }
            }
        } else {
            Toast.makeText(this, "This is the maximum number of digits allowed!", Toast.LENGTH_SHORT).show();
        }
    }

    private void setLocalAmount() {
        ((GlobalVariables) this.getApplication()).setAmount(editTextTerminal.getText().toString());
    }
}