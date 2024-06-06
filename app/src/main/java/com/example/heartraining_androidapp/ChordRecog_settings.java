package com.example.heartraining_androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChordRecog_settings extends AppCompatActivity {

    Button playChordRecog;
    Button backHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chord_recog_settings);

        playChordRecog = findViewById(R.id.button_play);
        backHome = findViewById(R.id.button_backHome);

        playChordRecog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChordRecog_settings.this, ChordRecog_play.class);
                startActivity(intent);
            }
        });

        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChordRecog_settings.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}