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

    Button playScalePres;

    Button changeScale;

    Button backHome;

    TextView gradeText;

    TextView scaleText;
    MediaPlayer mediaPlayer;

    AudioFilesManager audioFilesManager;

    Random rand = new Random();

    int currentGrade;
    int currentScale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade_recog_play);

        //region UI
        repeatGrade = findViewById(R.id.button_repeatGrade);
        revealGrade = findViewById(R.id.button_revealGrade);
        nextGrade = findViewById(R.id.button_nextGrade);
        playScalePres = findViewById(R.id.button_playScalePres);
        changeScale = findViewById(R.id.button_changeScale);

        backHome = findViewById(R.id.button_backHome);

        gradeText = findViewById(R.id.text_currentGradeRevealed);
        gradeText.setText("???");

        scaleText = findViewById(R.id.text_currentScaleRevealed);

        //endregion

        audioFilesManager = new AudioFilesManager();

        if(audioFilesManager.getScaleManager().getScales().size() > 0){
            currentScale = rand.nextInt(audioFilesManager.getScaleManager().getScales().size());
            scaleText.setText(audioFilesManager.getScaleManager().getScales().get(currentScale).getRoot());

            if(audioFilesManager.getScaleManager().getScales().get(currentScale).getGrades().size() > 0){
                currentGrade = rand.nextInt(audioFilesManager.getScaleManager().getScales().get(currentScale).getGrades().size());
            }else {
                currentGrade = -1;
            }

        }else {
            currentScale = -1;
        }



        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GradeRecog_play.this, MainActivity.class);
                startActivity(intent);
            }
        });

        changeScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentScale !=-1){
                    currentScale = rand.nextInt(audioFilesManager.getScaleManager().getScales().size());
                    scaleText.setText(audioFilesManager.getScaleManager().getScales().get(currentScale).getRoot());

                    if(audioFilesManager.getScaleManager().getScales().get(currentScale).getGrades().size() > 0){
                        currentGrade = rand.nextInt(audioFilesManager.getScaleManager().getScales().get(currentScale).getGrades().size());
                        gradeText.setText("???");
                    }
                }
            }
        });

        playScalePres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentGrade != -1){
                    if(audioFilesManager.getScaleManager().getScales().get(currentScale).getScalePresentation() != null){
                        mediaPlayer = MediaPlayer.create(GradeRecog_play.this, audioFilesManager.getScaleManager().getScales().get(currentScale).getScalePresentation().getId());
                        if(mediaPlayer.isPlaying()){
                            mediaPlayer.stop();
                        }
                        mediaPlayer.start();
                    }
                }
            }
        });

        repeatGrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentGrade != -1){
                    mediaPlayer = MediaPlayer.create(GradeRecog_play.this, audioFilesManager.getScaleManager().getScales().get(currentScale).getGrades().get(currentGrade).getId());
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
                if(currentGrade != -1){
                    gradeText.setText(audioFilesManager.getScaleManager().getScales().get(currentScale).getGrades().get(currentGrade).getName());
                }
            }
        });

        nextGrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentGrade != -1){
                    currentGrade = rand.nextInt(audioFilesManager.getScaleManager().getScales().get(currentScale).getGrades().size());
                    gradeText.setText("???");
                }
            }
        });


    }
}