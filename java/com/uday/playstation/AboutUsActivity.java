package com.uday.playstation;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        setTitle("About App");
        setContentView(R.layout.activity_about_us);

        VideoView vv= (VideoView)findViewById(R.id.videoView));
            vv.setVideoURI(Uri.parse("android.resource://" + getPackageName()+"/"+R.raw.kaspercity));
            MediaController mc=new MediaController(this);
            vv.setMediaController(mc);
            vv.start();
    }
}