package com.example.interactivecarapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class WifiAct extends AppCompatActivity {
    TextView tvLogin, tvswitchtext;
    EditText etSSID, etPassword;
    Button btnSave;
    SwitchCompat switchCompat;

    String loggedout = "Please login with your Wi-Fi user id and password";
    String loggedin = "Logged in to ";
    boolean logged = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);

        // Text View
        tvLogin = findViewById(R.id.tvLogin);
        tvswitchtext = findViewById(R.id.switchtext);
        // Edit texts
        etSSID = findViewById(R.id.etSSID);
        etPassword = findViewById(R.id.etPassword);
        // Buttons
        btnSave = findViewById(R.id.wifiBtn);
        // Switch
        switchCompat = findViewById(R.id.wifiSwitch);

        tvswitchtext.setVisibility(View.GONE);
        switchCompat.setVisibility(View.GONE);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (logged)
                {
                    logged = false;
                    btnSave.setText("Save");
                    tvLogin.setText(loggedout);
                    tvswitchtext.setVisibility(View.GONE);
                    switchCompat.setVisibility(View.GONE);
                    etSSID.setVisibility(View.VISIBLE);
                    etPassword.setVisibility(View.VISIBLE);
                }
                else
                {
                    logged = true;
                    btnSave.setText("Logout");
                    tvLogin.setText(loggedin + etSSID.getText().toString());
                    etSSID.setText("");
                    etPassword.setText("");
                    tvswitchtext.setVisibility(View.VISIBLE);
                    switchCompat.setVisibility(View.VISIBLE);
                    etSSID.setVisibility(View.GONE);
                    etPassword.setVisibility(View.GONE);
                }
            }
        });
    }
}