package com.uday.playstation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SecondProcess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_process);
        Handler j=new Handler();
        j.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SecondProcess.this,RegistrationActivity.class));

            }
        },2000);
    }
}