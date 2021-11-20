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

        Intent myIntent = getIntent();

        passedName = myIntent.getStringExtra("name");

        if(SaveUserInfo.getName(this).length() == 0)
        {
            tvLog.setText(R.string.login);
            OptionsMenuAct.this.startActivity(LoginAct);
        }
        else
        {
            tvLog.setText(R.string.logout);
            String name = SaveUserInfo.getName(getApplicationContext());
            tvWelcome.setText("Welcome Back " + name);
        }

        tvLog.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (tvLog.getText().equals("Login")) // need to fix
                {
                    OptionsMenuAct.this.startActivity(LoginAct);
                }
                else
                {
                    SaveUserInfo.setName(getApplicationContext(), "");
                    tvLog.setText(R.string.login);
                    tvWelcome.setText("Welcome, Please Sign In To");
                }

            }
        });

    }
}