package com.example.heartraining_androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Random;

public class ChordRecog_play extends AppCompatActivity {

    Button repeatChord;
    Button revealChord;
    Button nextChord;

    Button backHome;

    TextView chordText;
    MediaPlayer mediaPlayer;

    ArrayList<Integer> chordsID;
    ArrayList<String> chordNames;

    Random rand = new Random();

    int currentChord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chord_recog_play);

        //region utili
        repeatChord = findViewById(R.id.button_repeatChord);
        revealChord = findViewById(R.id.button_revealChord);
        nextChord = findViewById(R.id.button_nextChord);

        backHome = findViewById(R.id.button_backHome);

        chordText = findViewById(R.id.text_currentChordRevealed);
        chordText.setText("???");

        chordsID = listRawID();
        chordNames = listRawName();
        //endregion

        currentChord = rand.nextInt(chordsID.size());

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
                mediaPlayer = MediaPlayer.create(ChordRecog_play.this, chordsID.get(currentChord));
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                mediaPlayer.start();
            }
        });

        revealChord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                chordText.setText(translateChord(chordNames.get(currentChord)));

            }
        });

        nextChord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentChord = rand.nextInt(chordsID.size());
                chordText.setText("???");
            }
        });


    }

    private String translateChord(String initialString){
        String outputString = "";
        char[] inputCharArray = initialString.toCharArray();
        for(int i = 0; i<inputCharArray.length ; i++){
            if(inputCharArray[i] == '_'){
                outputString += Character.toUpperCase(inputCharArray[i+1]);
                i++;
            } else if (inputCharArray[i] == 's') {
                outputString += '#';
            } else {
                outputString += inputCharArray[i];
            }
        }
        return outputString;
    }
    public ArrayList<Integer> listRawID(){
        ArrayList<Integer> chordsID = new ArrayList<>();
        Field[] fields=R.raw.class.getFields();
        for(int i = 0; i < fields.length; i++){
            try {
                chordsID.add(Integer.valueOf(fields[i].getInt(fields[i])));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return chordsID;
    }

    public ArrayList<String> listRawName(){
        ArrayList<String> chordsName = new ArrayList<>();
        Field[] fields=R.raw.class.getFields();
        for(int i = 0; i < fields.length; i++){
            chordsName.add(fields[i].getName());
        }
        return chordsName;
    }



}