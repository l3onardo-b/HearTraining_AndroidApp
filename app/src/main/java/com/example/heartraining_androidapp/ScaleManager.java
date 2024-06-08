package com.example.heartraining_androidapp;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class ScaleManager {

    private ArrayList<Scale> scales;

    public ScaleManager(){

    }

    private void populateScales(){
        ArrayList<String> rawNames = listRawName();
        ArrayList<Integer> rawIds = listRawID();

        for (int i = 0; i < rawNames.size(); i++){
            if ((rawNames.get(i).toCharArray())[0] == 'g') {
                //ricerca esistenza scala
                //se presente aggiungi grado
                //altrimenti crea scala
            } else if((rawNames.get(i).toCharArray())[0] == 's'){
                //ricerca esistenza scala
                //se presente aggiungi presentazione scala
                //Altrimenti crea scala
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


}
