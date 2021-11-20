package com.example.interactivecarapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class LoginAct extends AppCompatActivity
{
    // Objects for widgets
    EditText etUser, etPass;
    Button btnSignIn, btnCreateAcc;
    SwitchCompat switchKeepSignIn;

    // username and password variables
    String username, password;

    // Intent for create user activity
    Intent NewUserAct;
    // Intnet for options menu activity
    Intent OptionsAct;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // find edit text views
        etUser = findViewById(R.id.etUser);
        etPass = findViewById(R.id.etPass);
        // find buttons
        btnSignIn = findViewById(R.id.btnSignIn);
        btnCreateAcc = findViewById(R.id.btnCreateAcc);
        // find switch
        switchKeepSignIn = findViewById(R.id.switchKeepSignIn);

        // initialize intents
        NewUserAct = new Intent(this, CreateUserAct.class);
        OptionsAct = new Intent(this, OptionsMenuAct.class);

        // create new database helper object
        DBHelper santasLilHelper = new DBHelper(this);
        // open db
        santasLilHelper.openDataBase();
        // close db
        santasLilHelper.close();

        // just a breakpoint for debugging
        int i = 0;

        btnSignIn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                // grab username and password
                username = etUser.getText().toString();
                password = etPass.getText().toString();
            }
        });

        btnCreateAcc.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                LoginAct.this.startActivity(NewUserAct);
            }
        });
    }
}