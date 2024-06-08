package com.example.heartraining_androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GradeRecog_settings extends AppCompatActivity {

    Button playGradeRecog;
    Button backHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade_recog_settings);


        playGradeRecog = findViewById(R.id.button_play);
        backHome = findViewById(R.id.button_backHome);

        playGradeRecog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GradeRecog_settings.this, GradeRecog_play.class);
                startActivity(intent);
            }
        });

        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GradeRecog_settings.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}