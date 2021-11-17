package com.example.interactivecarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;

public class LoginAct extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        DBHelper santasLilHelper = new DBHelper(this);
        santasLilHelper.openDataBase();


        santasLilHelper.close();

        int i = 0;
    }
}