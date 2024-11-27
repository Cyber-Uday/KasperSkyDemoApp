package com.uday.playstation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdProcess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_process);
        Handler n=new Handler();
        n.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(ThirdProcess.this,RegistrationActivity.class));
                finish();
            }
        },2000);
    }
}