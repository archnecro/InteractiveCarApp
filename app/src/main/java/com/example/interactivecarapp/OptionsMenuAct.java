package com.example.interactivecarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OptionsMenuAct extends AppCompatActivity {
    Intent LoginAct;
    Button btnKeyFob;
    TextView tvWelcome;
    TextView tvLog;

    String passedName = "";
    String name = "";

    boolean loggedin = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_menu);

        // Intents
        LoginAct = new Intent(this, LoginAct.class);

        // Buttons
        btnKeyFob = findViewById(R.id.btnKeyFob);

        // Text view
        tvWelcome = findViewById(R.id.tvWelcome);
        tvLog = findViewById(R.id.tvLog);

        if (SaveUserInfo.getName(this).length() == 0)
        {
            tvLog.setText(R.string.login);
            OptionsMenuAct.this.startActivity(LoginAct);
        }
        else
        {
            tvLog.setText(R.string.logout);
            name = SaveUserInfo.getName(getApplicationContext());
            tvWelcome.setText("Welcome Back " + name);
            loggedin = true;
        }

        tvLog.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (loggedin)
                {
                    loggedin = false;
                    SaveUserInfo.setName(getApplicationContext(), "");
                    tvLog.setText(R.string.login);
                    tvWelcome.setText("Welcome, Please Sign In To");
                }
                else
                {
                    OptionsMenuAct.this.startActivity(LoginAct);
                }

            }
        });

    }
}