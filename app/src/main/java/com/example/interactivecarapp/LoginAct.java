package com.example.interactivecarapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginAct extends AppCompatActivity
{
    // Objects for widgets
    EditText etUser, etPass;
    Button btnSignIn, btnCreateAcc;
    SwitchCompat switchKeepSignIn;
    TextView tvError;

    // User class
    User user;

    // username and password variables
    String email, password;

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
        // find tv
        tvError = findViewById(R.id.tvError);
        tvError.setVisibility(View.INVISIBLE);

        // initialize intents
        NewUserAct = new Intent(this, CreateUserAct.class);
        OptionsAct = new Intent(this, OptionsMenuAct.class);

        // create new database helper object
        DBHelper santasLilHelper = new DBHelper(this);


        btnSignIn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                // grab username and password
                email = etUser.getText().toString();
                password = etPass.getText().toString();

                // open db
                santasLilHelper.openDataBase();

                String q = "SELECT * FROM user WHERE email=\"" + email + "\"";
                boolean exists = santasLilHelper.CheckUserExists(q);

                if (exists)
                {
                    user = santasLilHelper.GetUser(q);
                    if (password.equals(user.getPassword()) == false)
                    {
                        tvError.setVisibility(View.VISIBLE);
                        tvError.setText("Password Incorrect");
                    }
                    else
                    {
                        tvError.setVisibility(View.INVISIBLE);

                        if (switchKeepSignIn.isChecked())
                        {
                            boolean dontRemember = false;
                            OptionsAct.putExtra("remember", dontRemember);
                            SaveUserInfo.setName(getApplicationContext(), user.getFirstName());
                            finish();
                            LoginAct.this.startActivity(OptionsAct);
                        }
                        else
                        {
                            boolean dontRemember = true;
                            OptionsAct.putExtra("remember", dontRemember);
                            OptionsAct.putExtra("name", user.getFirstName());
                            finish();
                            LoginAct.this.startActivity(OptionsAct);
                        }
                    }
                }
                else
                {
                    tvError.setVisibility(View.VISIBLE);
                    tvError.setText("User Not Found");
                }

                santasLilHelper.close();
            }
        });

        btnCreateAcc.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                finish();
                LoginAct.this.startActivity(NewUserAct);
            }
        });
    }
}