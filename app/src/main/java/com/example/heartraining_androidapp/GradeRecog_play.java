package com.example.heartraining_androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class GradeRecog_play extends AppCompatActivity {

    Button repeatGrade;
    Button revealGrade;
    Button nextGrade;

    Button backHome;

    TextView gradeText;

    TextView scaleText;
    MediaPlayer mediaPlayer;

    AudioFilesManager audioFilesManager;

    Random rand = new Random();

    int currentGrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade_recog_play);

        //region UI
        repeatGrade = findViewById(R.id.button_repeatGrade);
        revealGrade = findViewById(R.id.button_revealGrade);
        nextGrade = findViewById(R.id.button_nextGrade);

        backHome = findViewById(R.id.button_backHome);

        gradeText = findViewById(R.id.text_currentGradeRevealed);
        gradeText.setText("???");

        scaleText = findViewById(R.id.text_currentScaleRevealed);
        scaleText = audioFilesManager

        //endregion

        audioFilesManager = new AudioFilesManager();
        if(audioFilesManager.getGrades().size() > 0){
            currentGrade = rand.nextInt(audioFilesManager.getGrades().size());
        }

        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GradeRecog_play.this, MainActivity.class);
                startActivity(intent);
            }
        });

        repeatGrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audioFilesManager.getGrades().size() > 0){
                    mediaPlayer = MediaPlayer.create(GradeRecog_play.this, audioFilesManager.getGrades().get(currentGrade).getId());
                    if(mediaPlayer.isPlaying()){
                        mediaPlayer.stop();
                    }
                    mediaPlayer.start();
                }
            }
        });

        revealGrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audioFilesManager.getGrades().size() > 0){
                    gradeText.setText(audioFilesManager.getGrades().get(currentGrade).getName());
                }
            }
        });

        nextGrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audioFilesManager.getGrades().size() > 0){
                    currentGrade = rand.nextInt(audioFilesManager.getGrades().size());
                    gradeText.setText("???");
                }
            }
        });


    }
}