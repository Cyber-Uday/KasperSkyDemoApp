package com.uday.playstation;

import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.Locale;

public class StatusFragment extends Fragment {
    Button btn_speak;
    EditText et_enteryourtext;
    SeekBar sb_pitch,sb_speed;
    TextToSpeech textToSpeech;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //laview.setAnimation(R.raw.lottiefile);
        //laview.playAnimation();
        //laview.loop(true);
        View view = inflater.inflate(R.layout.fragment_status, container, false);

        et_enteryourtext= view.findViewById(R.id.et_fragment_status_entertext);
        sb_pitch=view.findViewById(R.id.sb_status_pitch);
        sb_speed=view.findViewById(R.id.sb_status_speed);


        /*//iam new created here
        sb_pitch.setProgress(10); // Set the seek bar value to 10
        sb_speed.setProgress(10);*/




        btn_speak=view.findViewById(R.id.btn_status_speak);
        {
            btn_speak.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    speakText();

                }
            });
        }
        //current fragment
        textToSpeech =new TextToSpeech(getActivity(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status==TextToSpeech.SUCCESS)
                {
                  int result=textToSpeech.setLanguage(Locale.US);
                  if (result==TextToSpeech.LANG_NOT_SUPPORTED|| result==TextToSpeech.LANG_MISSING_DATA)
                  {
                      Toast.makeText(getActivity(),"Languages is Not Supportive",Toast.LENGTH_SHORT).show();
                  }
                  else
                  {
                      speakText();
                  }
                }
                else
                {
                    Toast.makeText(getActivity(),"Failed to Inilization",Toast.LENGTH_SHORT).show();
                }

            }
        });

        return view;

        // Inflate the layout for this fragment
        //  button = findViewById(R.id.open_video);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i=new Intent(getApplicationContext() ,VideoViewHere.class);
//                startActivity(i);
//
//            }
//        },2000);
    }
    //        sb_pitch.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar sb_pitch, int progress, boolean fromUser) {
//                if (progress < 10) {
//                    sb_pitch.setProgress(10);
//       }
//            }


    private void speakText() {
        String text=et_enteryourtext.getText().toString();
        if ("".equals(text))
        {
            text="welcome to Kasper sky security app";
        }
        float pitch=(float) sb_pitch.getProgress()/80;
        textToSpeech.setPitch(pitch);

        float speed=(float)sb_speed.getProgress()/80;
        textToSpeech.setSpeechRate(speed);

        int pitch1=(int) sb_pitch.getProgress()/10;
        textToSpeech.setPitch(pitch);

        int speed1=(int) sb_speed.getProgress()/10;
        textToSpeech.setSpeechRate(speed);

        sb_speed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress<10)
                {
                    sb_speed.setProgress((int) speed1);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        sb_pitch.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress<10)
                {
                    sb_pitch.setProgress((int ) pitch1);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //seek bar chi value 10 percent peksha kami zhlai tar kay karava lagel
        //10 chi Kami aslel tari pn tyani 10 percent pakdla pahije


      /*
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {*/
            //hi uday if suppose half run zhla but bakicha run hoaycha baki tahtas took Quesue_Flush
           textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null,null);
      /*  }

        else

        {
            textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null);
        }*/

    }


}
