package com.example.interactivecarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateUserAct extends AppCompatActivity {
    EditText etVin, etFirstName, etLastname, etAddress, etZip, etEmail, etPhone, etPass, etConfirm;
    Button btnSignUp;
    DBHelper dbHalp;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        // find all the edit texts
        etVin = findViewById(R.id.etVin);
        etFirstName = findViewById(R.id.etFirstName);
        etLastname = findViewById(R.id.etLastName);
        etAddress = findViewById(R.id.etAddy);
        etZip = findViewById(R.id.etZip);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etPass = findViewById(R.id.etPass);
        etConfirm = findViewById(R.id.etConfirm);

        // button
        btnSignUp = findViewById(R.id.btnSignUp);

        // db helper
        dbHalp = new DBHelper(this);

        // make sure the formatting for the phone number looks good
        etPhone.addTextChangedListener(new PhoneNumberFormattingTextWatcher());

        btnSignUp.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

            }
        });
    }
}