package com.example.heartraining_androidapp;

import java.util.ArrayList;

public class Scale {

    private String root;

    private AudioFile scalePresentation;
    private ArrayList<AudioFile> grades;

    public Scale(String root, AudioFile scalePresentation){
        this.root = root;
        this.scalePresentation = scalePresentation;
        this.grades = new ArrayList<AudioFile>();
    }

    //region Getter e setter

    public ArrayList<AudioFile> getGrades() {
        return grades;
    }

    public AudioFile getScalePresentation() {
        return scalePresentation;
    }

    public String getRoot() {
        return root;
    }


    public void setScalePresentation(AudioFile scalePresentation) {
        this.scalePresentation = scalePresentation;
    }

    //endregion

}
