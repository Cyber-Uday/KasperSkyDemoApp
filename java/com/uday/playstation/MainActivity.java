package com.uday.playstation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    LottieAnimationView laview;
    Animation sun2anim;
    ImageView sun2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //laview.setAnimation(R.raw.lottiefile);
        //laview.playAnimation();
        //laview.loop(true);


        Handler p = new Handler();
        p.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this, loginprocess2.class));
               finish();
            }
        }, 2000);

    }
}







