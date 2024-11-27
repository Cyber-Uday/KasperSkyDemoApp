package com.uday.playstation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class FlashAnim extends AppCompatActivity {
    LottieAnimationView laview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_anim);
        //laview.setAnimation(R.raw.lottiefile);
        //laview.playAnimation();
        //laview.loop(true);
        Handler y=new Handler();
        y.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(FlashAnim.this,ProcessActivity.class));
                finish();
            }
        },1000);
    }
}