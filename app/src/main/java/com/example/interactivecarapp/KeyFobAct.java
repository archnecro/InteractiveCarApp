package com.example.interactivecarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class KeyFobAct extends AppCompatActivity
{
    Button btnLock, btnUnlock, btnStart, btnStop, btnOn, btnOff, btnHornOn, btnHornOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_key_fob);
        // Buttons
        btnLock = findViewById(R.id.btnLock);
        btnUnlock = findViewById(R.id.btnUnlock);
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        btnOn = findViewById(R.id.btnOn);
        btnOff = findViewById(R.id.btnOff);
        btnHornOn = findViewById(R.id.btnStartHorn);
        btnHornOff = findViewById(R.id.btnStopHorn);

        btnLock.setBackgroundResource(R.drawable.btngreen);
        btnUnlock.setBackgroundResource(R.drawable.btnred);
        btnStart.setBackgroundResource(R.drawable.btngreen);
        btnStop.setBackgroundResource(R.drawable.btnred);
        btnOn.setBackgroundResource(R.drawable.btngreen);
        btnOff.setBackgroundResource(R.drawable.btnred);
        btnHornOn.setBackgroundResource(R.drawable.btngreen);
        btnHornOff.setBackgroundResource(R.drawable.btnred);

        btnLock.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btnUnlock.setBackgroundResource(R.drawable.btngreen);
                btnLock.setBackgroundResource(R.drawable.btnred);
            }
        });

        btnUnlock.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btnLock.setBackgroundResource(R.drawable.btngreen);
                btnUnlock.setBackgroundResource(R.drawable.btnred);
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btnStop.setBackgroundResource(R.drawable.btngreen);
                btnStart.setBackgroundResource(R.drawable.btnred);
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btnStart.setBackgroundResource(R.drawable.btngreen);
                btnStop.setBackgroundResource(R.drawable.btnred);
            }
        });
        btnOn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btnOff.setBackgroundResource(R.drawable.btngreen);
                btnOn.setBackgroundResource(R.drawable.btnred);
            }
        });
        btnOff.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btnOn.setBackgroundResource(R.drawable.btngreen);
                btnOff.setBackgroundResource(R.drawable.btnred);
            }
        });
        btnHornOn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btnHornOff.setBackgroundResource(R.drawable.btngreen);
                btnHornOn.setBackgroundResource(R.drawable.btnred);
            }
        });
        btnHornOff.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btnHornOn.setBackgroundResource(R.drawable.btngreen);
                btnHornOff.setBackgroundResource(R.drawable.btnred);
            }
        });

    }


}