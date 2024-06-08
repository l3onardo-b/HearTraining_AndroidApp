package com.example.heartraining_androidapp;

public class AudioFile {

    private int id;
    private String fileName;
    private String name;

    public AudioFile(int id, String fileName){
        this.id = id;
        this.fileName = fileName;
        name = translateFileName(fileName);
    }

    //region Getter e setter

    public int getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public String getName() {
        return name;
    }

    //endregion

    //region Ausiliari
    private String translateFileName(String initialString){
        String outputString = "";
        char[] inputCharArray = initialString.toCharArray();
        /**
         * La traduzione parte dal secondo char perche' il primo e' necessario per capirne il tipo
         */
        //Convenzione stringa: tipo - scala(2) - cose da leggere
        for(int i = 3; i<inputCharArray.length ; i++){
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
    //endregion
}
