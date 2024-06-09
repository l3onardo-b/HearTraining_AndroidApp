package com.example.heartraining_androidapp;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class ScaleManager {

    private ArrayList<Scale> scales;

    public ScaleManager(){
        scales = new ArrayList<Scale>();
        populateScales();
    }


    public ArrayList<Scale> getScales() {
        return scales;
    }

    public void populateScales(){
        ArrayList<String> rawNames = listRawName();
        ArrayList<Integer> rawIds = listRawID();

        for (int i = 0; i < rawNames.size(); i++){
            String rootRic = Character.toString(rawNames.get(i).toCharArray()[1]);

            if(rawNames.get(i).toCharArray()[2] != 'n'){
                if(rawNames.get(i).toCharArray()[2] == 's'){
                    rootRic += '#';
                }else {
                    rootRic += (rawNames.get(i).toCharArray()[2]);
                }
            }

            if ((rawNames.get(i).toCharArray())[0] == 'g') {
                int pos = searchScaleRoot(rootRic);
                //se presente aggiungi grado
                if(pos != -1){
                    scales.get(pos).getGrades().add(new AudioFile(rawIds.get(i), rawNames.get(i)));
                }else{ //altrimenti crea scala
                    scales.add(new Scale(rootRic, null));
                    scales.get(scales.size()-1).getGrades().add(new AudioFile(rawIds.get(i), rawNames.get(i)));
                    //aggiungi grado a scala
                }

            } else if((rawNames.get(i).toCharArray())[0] == 's'){

                AudioFile scalePres = new AudioFile(rawIds.get(i), rawNames.get(i));

                int pos = searchScaleRoot(rootRic);
                //se presente aggiungi grado
                if(pos != -1){
                    scales.get(pos).setScalePresentation(scalePres);
                }else{ //altrimenti crea scala
                    scales.add(new Scale(rootRic, scalePres));
                }
            }
        }
    }


    private int searchScaleRoot(String rootRic){
        int pos = -1;
        int i = 0;

        while(pos == -1 && i < scales.size()){
            if(scales.get(i).getRoot().equals(rootRic)){
                pos = i;
            }
            i++;
        }
        return pos;
    }

    private ArrayList<Integer> listRawID(){
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

    private ArrayList<String> listRawName(){
        ArrayList<String> chordsName = new ArrayList<>();
        Field[] fields=R.raw.class.getFields();
        for(int i = 0; i < fields.length; i++){
            chordsName.add(fields[i].getName());
        }
        return chordsName;
    }


}
