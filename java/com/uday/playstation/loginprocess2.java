
package com.uday.playstation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class loginprocess2 extends AppCompatActivity {
    LottieAnimationView laview;

    ImageView img_logo;
    EditText et_username,et_password;
    CheckBox chk_show_hide;
    Button btn_login;
    VideoView video2;
    TextView tv_new_user,tv_termsandcondition;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginprocess2);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = preferences.edit();

        if (preferences.getBoolean("isLogin", false)) {
            Intent i = new Intent(loginprocess2.this, HomeActivity.class);
            startActivity(i);
            finish();
        }
        //img_logo=findViewById(R.id.imageView);

        video2 = (VideoView) findViewById(R.id.video2);
        video2.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.hackerlogin));
        video2.start();
        video2.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                mp.setLooping(true);
            }
        });


        tv_termsandcondition = findViewById(R.id.tv_login_termsandcondition);
        et_username = findViewById(R.id.et_login_username);
        et_password = findViewById(R.id.et_login_password);
        chk_show_hide = findViewById(R.id.check_login_show_hide);
        btn_login = findViewById(R.id.btn_login_login);
        tv_new_user = findViewById(R.id.tv_login_new_user);
        //laview.setAnimation(R.raw.lottiefile);
        //laview.playAnimation();
        //laview.loop(true);
        chk_show_hide.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    et_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    et_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_username.getText().toString().isEmpty()) {
                    et_username.setError("Please enter your username");
                } else if (et_username.getText().toString().length() < 8) {
                    et_username.setError("Username must be greater than 8 Character");
                } else if (et_password.getText().toString().isEmpty()) {
                    et_password.setError("Please enter your password");
                } else if (et_username.getText().toString().length() < 8) {
                    et_password.setError("Password must be greater than 8 Character");
                } else {
                  /*  if(et_username.getText().toString().equals("UdayPayghon") && et_password.getText().toString().equals("Useruday15."))
                    {
                        Toast.makeText(loginprocess2.this,"login Sucess",Toast.LENGTH_SHORT).show();
                                Intent i =new Intent(loginprocess2.this,HomeActivity.class);
                                i.putExtra("username",et_username.getText().toString());
                                i.putExtra("password",et_password.getText().toString());
                                editor.putBoolean("isLogin",true).commit();
                                startActivity(i);
                                finish();

                    }
                    else
                    {
                        Toast.makeText(loginprocess2.this,"login Fail",Toast.LENGTH_SHORT).show();
                    }*/
                    Toast.makeText(loginprocess2.this, "login Sucess", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(loginprocess2.this, HomeActivity.class);
                    i.putExtra("username", et_username.getText().toString());
                    i.putExtra("password", et_password.getText().toString());
                    editor.putBoolean("isLogin", true).commit();
                    startActivity(i);
                    finish();
                }
            }
        });
        tv_new_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(loginprocess2.this, SecondProcess.class);
                startActivity(i);
                finish();
            }
        });

        tv_termsandcondition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);

                i.setData(Uri.parse("https://sites.google.com/view/udaypayghon104/home?authuser=0"));
                startActivity(i);
            }
        });
    }
        @Override
        protected void onResume()
        {
            video2.resume();
            super.onResume();
        }

        @Override
        protected  void onPause()
        {
            video2.suspend();
            super.onPause();
        }
        @Override
        protected  void onDestroy()
        {
            video2.stopPlayback();
            super.onDestroy();
        }


}