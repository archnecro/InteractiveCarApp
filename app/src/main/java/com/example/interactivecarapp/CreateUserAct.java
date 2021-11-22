package com.example.interactivecarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CreateUserAct extends AppCompatActivity {
    EditText etVin, etFirstName, etLastname, etAddress, etZip, etEmail, etPhone, etPass, etConfirm;
    Button btnSignUp;
    DBHelper dbHalp;
    TextView tvError;
    User newUser;

    String vin, firstname, lastname, address, email, phone, pass, confirm;
    int zip;

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

        // text view
        tvError = findViewById(R.id.tvError);

        // make sure the formatting for the phone number looks good
        etPhone.addTextChangedListener(new PhoneNumberFormattingTextWatcher());

        btnSignUp.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
               if (CheckTexts())
               {
                    GetTextValues();
                    newUser = new User(email, pass, address, zip, phone, vin, firstname, lastname);
               }
            }
        });
    }

    public boolean CheckTexts()
    {
        if (etVin.getText().toString().trim().length() == 0)
        {
            tvError.setText("*Please enter VIN number");
            return false;
        }
        else if (etFirstName.getText().toString().trim().length() == 0)
        {
            tvError.setText("*All fields must be complete");
            return false;
        }
        else if (etLastname.getText().toString().trim().length() == 0)
        {
            tvError.setText("*All fields must be complete");
            return false;
        }
        else if (etAddress.getText().toString().trim().length() == 0)
        {
            tvError.setText("*All fields must be complete");
            return false;
        }
        else if (etZip.getText().toString().trim().length() == 0)
        {
            tvError.setText("*All fields must be complete");
            return false;
        }
        else if (etEmail.getText().toString().trim().length() == 0)
        {
            tvError.setText("*All fields must be complete");
            return false;
        }
        else if (etPhone.getText().toString().trim().length() == 0)
        {
            tvError.setText("*All fields must be complete");
            return false;
        }
        else if (etPass.getText().toString().trim().length() == 0)
        {
            tvError.setText("*All fields must be complete");
            return false;
        }
        else if (etConfirm.getText().toString().trim().length() == 0)
        {
            tvError.setText("*Please confirm password");
            return false;
        }
        else if (etVin.getText().toString().trim().length() < 17)
        {
            tvError.setText("*VIN not valid");
            return false;
        }
        else if (etZip.getText().toString().trim().length() < 5)
        {
            tvError.setText("*Zip not valid");
            return false;
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(etEmail.getText().toString().trim()).matches())
        {
            tvError.setText("*Email not valid");
            return false;
        }
        else if (etPhone.getText().toString().trim().length() < 10)
        {
            tvError.setText("*Phone number not valid");
            return false;
        }
        else if (!etPass.getText().toString().trim().equals(etConfirm.getText().toString().trim()))
        {
            tvError.setText("*Passwords did not match");
            return false;
        }
        else if (dbHalp.CheckUserExists("SELECT * FROM user WHERE email=\"" + etEmail.getText().toString() + "\""))
        {
            tvError.setText("*User already exists");
            return false;
        }
        else
        {
            return true;
        }
    }

    public void GetTextValues()
    {
        vin = etVin.getText().toString().trim();
        firstname = etFirstName.getText().toString().trim();
        lastname = etLastname.getText().toString().trim();
        address = etAddress.getText().toString().trim();
        zip = Integer.parseInt(etZip.getText().toString());
        email = etEmail.getText().toString().trim();
        phone = etPhone.getText().toString().trim();
        pass = etPass.getText().toString().trim();
        confirm = etConfirm.getText().toString().trim();
    }
}