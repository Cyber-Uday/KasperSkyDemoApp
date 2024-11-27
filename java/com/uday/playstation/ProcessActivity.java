package com.uday.playstation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class ProcessActivity extends AppCompatActivity {
    LottieAnimationView laview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process);
        //laview.setAnimation(R.raw.lottiefile);
        //laview.playAnimation();
        //laview.loop(true);
        Handler j=new Handler();
        j.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(ProcessActivity.this,ProcessActivity2.class));
              finish();
            }
        },2000);
    }
}