package com.example.analogdigitalclock;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;
import java.util.Locale;
/**
 *  Project : CLOCK [ANALOG, DIGITAL, DATE]
 *  Language : JAVA
 *  Author : IMTIAZ ADAR
 */
public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    TextClock digiClock, digiClock1;
    Button exitButton;
    TextView tView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        digiClock = findViewById(R.id.digitalid);
        digiClock1 = findViewById(R.id.digitalid2);
        tView = findViewById(R.id.textviewid1);
        exitButton = findViewById(R.id.exitB);
        Typeface myfont = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/digitalfont.ttf");
        digiClock.setTypeface(myfont);
        digiClock1.setTypeface(myfont);
        tView.setTypeface(myfont);
        exitButton.setTypeface(myfont);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.setLooping(false);
                    mediaPlayer.stop();
                }
                System.exit(1);
                finish();
            }
        });
        if(mediaPlayer == null){
            mediaPlayer = MediaPlayer.create(this, R.raw.inspire);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
        }

    }
}