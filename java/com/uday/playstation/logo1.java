package com.uday.playstation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class logo1 extends AppCompatActivity {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo1);

        preferences= PreferenceManager.getDefaultSharedPreferences(logo1.this);
        editor=preferences.edit();




        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            Toast.makeText(logo1.this,"FCM Token is fail",Toast.LENGTH_SHORT).show();
                            return;
                        }

                        // Get new FCM registration token
                        String t1 = task.getResult();
                        editor.putString("token",t1).commit();

                        // Log and toast
                        Toast.makeText(logo1.this, t1, Toast.LENGTH_SHORT).show();
                    }
                });


        Handler o=new Handler();
        o.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(logo1.this,MainActivity.class));
                finish();
            }
        },1000);
    }
}
