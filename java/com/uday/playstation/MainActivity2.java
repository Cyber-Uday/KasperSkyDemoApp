package com.uday.playstation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity2 extends AppCompatActivity {
    LottieAnimationView laview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //laview.setAnimation(R.raw.lottiefile);
        //laview.playAnimation();
        //laview.loop(true);
        Handler b=new Handler();
        b.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity2.this, loginprocess2.class));
                finish();
            }
        },2000);
    }
}