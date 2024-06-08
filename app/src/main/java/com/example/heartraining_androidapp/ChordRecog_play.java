package com.example.heartraining_androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class ChordRecog_play extends AppCompatActivity {

    Button repeatChord;
    Button revealChord;
    Button nextChord;

    Button backHome;

    TextView chordText;
    MediaPlayer mediaPlayer;

    AudioFilesManager audioFilesManager;

    Random rand = new Random();

    int currentChord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chord_recog_play);

        //region UI
        repeatChord = findViewById(R.id.button_repeatGrade);
        revealChord = findViewById(R.id.button_revealGrade);
        nextChord = findViewById(R.id.button_nextGrade);

        backHome = findViewById(R.id.button_backHome);

        chordText = findViewById(R.id.text_currentGradeRevealed);
        chordText.setText("???");

        //endregion

        audioFilesManager = new AudioFilesManager();
        if(audioFilesManager.getChords().size() > 0){
            currentChord = rand.nextInt(audioFilesManager.getChords().size());
        }

        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChordRecog_play.this, MainActivity.class);
                startActivity(intent);
            }
        });

        repeatChord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audioFilesManager.getChords().size() > 0){
                    mediaPlayer = MediaPlayer.create(ChordRecog_play.this, audioFilesManager.getChords().get(currentChord).getId());
                    if(mediaPlayer.isPlaying()){
                        mediaPlayer.stop();
                    }
                    mediaPlayer.start();
                }

            }
        });

        revealChord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audioFilesManager.getChords().size() > 0){
                    chordText.setText(audioFilesManager.getChords().get(currentChord).getName());
                }
            }
        });

        nextChord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audioFilesManager.getChords().size() > 0){
                    currentChord = rand.nextInt(audioFilesManager.getChords().size());
                    chordText.setText("???");
                }
            }
        });


    }

}











