package com.example.heartraining_androidapp;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class AudioFilesManager {

    private ArrayList<AudioFile> chords;



    public AudioFilesManager(){
        chords = new ArrayList<AudioFile>();


        populateArrays();
    }

    //region Getter e setter

    public ArrayList<AudioFile> getChords() {
        return chords;
    }

    //endregion

    //region Ausiliari


    private void populateArrays(){
        ArrayList<String> rawNames = listRawName();
        ArrayList<Integer> rawIds = listRawID();

        for (int i = 0; i < rawNames.size(); i++){
            if((rawNames.get(i).toCharArray())[0] == 'c'){
                chords.add(new AudioFile(rawIds.get(i), rawNames.get(i)));
            } else if ((rawNames.get(i).toCharArray())[0] == 'g') {

            } else if((rawNames.get(i).toCharArray())[0] == 's'){

            }
        }
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

    //endregion

}
