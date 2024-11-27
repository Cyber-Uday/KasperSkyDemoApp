package com.uday.playstation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class UdayProcess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uday_process);
        //laview.setAnimation(R.raw.lottiefile);
        //laview.playAnimation();
        //laview.loop(true);
        Handler k=new Handler();
        k.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(UdayProcess.this,loginprocess2.class));
                finish();
            }
        },2000);
    }
}