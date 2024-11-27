package com.uday.playstation;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class HomeActivity extends AppCompatActivity {

    Boolean doubletap=false;
    SharedPreferences preferences;
    String str_username,str_password;
    SharedPreferences.Editor editor,editor1;

    ViewPagerAdapter viewPagerAdapter;
    TabLayout tablayout;
    ViewPager viewPager;


   @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       setContentView(R.layout.activity_home2);
        setTitle("KasperSky Security ");
        preferences= PreferenceManager.getDefaultSharedPreferences(HomeActivity.this);
        editor=preferences.edit();
        tablayout= findViewById(R.id.tablayout);
        viewPager =findViewById(R.id.viewpager);

        Intent i=getIntent();
        str_username=i.getStringExtra("username");
       str_password=i.getStringExtra("password");

        viewPagerAdapter =new ViewPagerAdapter(getSupportFragmentManager());
        //update modify create kela gela pahije so that's why use okay
        viewPagerAdapter.addFragment(new ChatsFragment(),"Home");
        viewPagerAdapter.addFragment(new StatusFragment(),"Speak");
        viewPagerAdapter.addFragment(new CallsFragment(),"Server");
        viewPager.setAdapter(viewPagerAdapter);
        tablayout.setupWithViewPager(viewPager);
        preferences =getSharedPreferences("perfs",MODE_PRIVATE);
        boolean isFirstTime=preferences.getBoolean("firstTime",true);
        if(isFirstTime)
        {
            welcome();
        }

    }
    private void welcome() {
        AlertDialog.Builder ad=new AlertDialog.Builder(this);
        ad.setTitle(" KasperSky APP");
        ad.setMessage("Hello,Please Welcome to India's Top Security App ");
        ad.setPositiveButton("Thank You", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        }).create().show();
        editor=preferences.edit();
        editor.putBoolean("firstTime",false).commit();}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.home_menu_my_profile)
        {
            Intent i = new Intent(HomeActivity.this,MyprofileActivity.class);
            i.putExtra("username",str_username);
            i.putExtra("password",str_password);
            startActivity(i);

        }
        if(item.getItemId() == R.id.home_menu_settings)
        {
            Intent i = new Intent(HomeActivity.this,SettingsActivity.class);
            startActivity(i);
        }
        if(item.getItemId() == R.id.home_menu_contactus)
        {
            Intent i = new Intent(HomeActivity.this,ContactUsActivity.class);
            startActivity(i);
        }
        if(item.getItemId() == R.id.home_menu_aboutus)
        {
            Intent i = new Intent(HomeActivity.this,AboutUsActivity.class);
            startActivity(i);
        }
        if(item.getItemId() == R.id.home_menu_logout)
        {
            AlertDialog.Builder adb = new AlertDialog.Builder(HomeActivity.this);
            adb.setTitle("Logout");
            adb.setMessage("Are you sure you want to logout");
            adb.setPositiveButton("LOGOUT", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(HomeActivity.this, "Logged out!!", Toast.LENGTH_SHORT).show();
                    Handler h = new Handler();
                    h.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent i = new Intent(HomeActivity.this,loginprocess2.class);
                            editor.putBoolean("isLogin",false).commit();
                            startActivity(i);
                            finish();
                        }
                    },1000);
                }
            });
            adb.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            }).create().show();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        if(doubletap)
        {
            super.onBackPressed();
        }
        else
        {
            Toast.makeText(HomeActivity.this,"Press agian to exist app",Toast.LENGTH_SHORT).show();
            doubletap=true;
            Handler h=new Handler();
            h.postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubletap=false;
                }
            },1500);
        }
    }
}

