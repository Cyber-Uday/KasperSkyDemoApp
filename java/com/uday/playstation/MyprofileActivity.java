package com.uday.playstation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class MyprofileActivity extends AppCompatActivity {
    LottieAnimationView laview;

    String Username1,Password1;
    TextView tv_username,tv_password,tv_my_token;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("MY PROFILE");

        preferences= PreferenceManager.getDefaultSharedPreferences(MyprofileActivity.this);
        editor=preferences.edit();

        setContentView(R.layout.activity_myprofile);

        tv_username=findViewById(R.id.tv_profile_username1);
        tv_password=findViewById(R.id.tv_profile_password1);
        tv_my_token=findViewById(R.id.tv_profile_mytoken);

        Intent i=getIntent();

        Username1=i.getStringExtra("username");
        Password1= i.getStringExtra("password");

        tv_username.setText(Username1);
        tv_password.setText(Password1);
        tv_my_token.setText(preferences.getString("token",""));
        Toast.makeText(MyprofileActivity.this,Username1+" "+Password1,Toast.LENGTH_SHORT).show();



        //laview.setAnimation(R.raw.lottiefile);
        //laview.playAnimation();
        //laview.loop(true);

    }
}