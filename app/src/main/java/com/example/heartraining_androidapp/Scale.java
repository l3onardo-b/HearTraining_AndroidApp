package com.example.heartraining_androidapp;

import java.util.ArrayList;

public class Scale {

    private char root;

    private AudioFile scalePresentation;
    private ArrayList<AudioFile> notes;

    public Scale(char root, AudioFile scalePresentation, ArrayList<AudioFile> notes){
        this.root = root;
        this.scalePresentation = scalePresentation;
        this.notes = notes;
    }

    //region Getter e setter

    public ArrayList<AudioFile> getNotes() {
        return notes;
    }

    //endregion

}
