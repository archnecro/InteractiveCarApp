package com.example.interactivecarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.io.IOException;

public class OptionsMenuAct extends AppCompatActivity {
    Intent LoginAct;
    Button btnKeyFob;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_menu);

        // Intents
        LoginAct = new Intent(this, com.example.interactivecarapp.LoginAct.class);

        // Buttons
        btnKeyFob = findViewById(R.id.btnKeyFob);

        if(SaveUserInfo.getUsername(this).length() == 0)
        {
            OptionsMenuAct.this.startActivity(LoginAct);
        }

    }
}