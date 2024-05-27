package com.example.heartraining_androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button playChordRecog;
    Button playGradeRecog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playChordRecog = findViewById(R.id.button_chordRecog);
        playGradeRecog = findViewById(R.id.Button_gradeRecog);

        playChordRecog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChordRecog_settings.class);
                startActivity(intent);
            }
        });

        playGradeRecog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GradeRecog_settings.class);
                startActivity(intent);
            }
        });

    }
}