package com.example.heartraining_androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChordRecog_play extends AppCompatActivity {

    Button reapeatChord;

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chord_recog_play);

        reapeatChord = findViewById(R.id.button_repeatChord);

        reapeatChord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer == null){
                    mediaPlayer = MediaPlayer.create(ChordRecog_play.this, R.raw.Aaug);
                }
                mediaPlayer.start();
            }
        });


    }


}