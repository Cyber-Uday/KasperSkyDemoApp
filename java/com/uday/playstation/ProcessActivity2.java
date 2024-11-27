package com.uday.playstation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class ProcessActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process2);
        Handler f=new Handler();
        f.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(ProcessActivity2.this,HomeActivity.class));
                finish();

            }
        },2500);

    }
}