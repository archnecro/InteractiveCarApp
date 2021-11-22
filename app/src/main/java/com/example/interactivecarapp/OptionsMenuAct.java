package com.example.interactivecarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class OptionsMenuAct extends AppCompatActivity {
    Intent LoginAct;
    Button btnKeyFob;
    TextView tvWelcome;
    TextView tvLog;

    String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_menu);

        // Intents
        LoginAct = new Intent(this, LoginAct.class);
        Intent myIntent = getIntent();

        // Buttons
        btnKeyFob = findViewById(R.id.btnKeyFob);

        // Text view
        tvWelcome = findViewById(R.id.tvWelcome);
        tvLog = findViewById(R.id.tvLog);

        // variable to determine whether to save username or not
        boolean dontRemember = myIntent.getBooleanExtra("remember", false);

        // passed name
        String passedName = myIntent.getStringExtra("name");


        if (dontRemember) // if user logs in but doesn't want to be remembered
        {
            // capitalize first letter
            passedName = passedName.substring(0, 1).toUpperCase(Locale.ROOT) + passedName.substring(1);
            // set login/out text to logout
            tvLog.setText(R.string.logout);
            // clear saved username
            SaveUserInfo.setName(getApplicationContext(), "");
            // set top text to welcome user
            tvWelcome.setText("Welcome Back " + passedName);
        }
        else if (SaveUserInfo.getName(this).length() == 0) // if user opens app and wasn't remembered
        {
            // finish will stop user from being able to go back to this page until logged in
            finish();
            // set login/out text to login
            tvLog.setText(R.string.login);
            // start login activity
            OptionsMenuAct.this.startActivity(LoginAct);
        }
        else // if user opens app and was remembered
        {
            // set login/out text to logout
            tvLog.setText(R.string.logout);
            // get saved user name
            name = SaveUserInfo.getName(getApplicationContext());
            // capitalize first letter
            name = name.substring(0, 1).toUpperCase(Locale.ROOT) + name.substring(1);
            // set top text to welcome user
            tvWelcome.setText("Welcome Back " + name);
        }

        tvLog.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                SaveUserInfo.setName(getApplicationContext(), "");
                finish();
                OptionsMenuAct.this.startActivity(LoginAct);
            }
        });

    }
}