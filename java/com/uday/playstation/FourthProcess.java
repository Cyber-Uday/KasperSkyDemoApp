package com.uday.playstation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class FourthProcess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_process);
        //laview.setAnimation(R.raw.lottiefile);
        //laview.playAnimation();
        //laview.loop(true);
        Handler h=new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(FourthProcess.this,loginprocess2.class));
            }
        },2000);
    }
}