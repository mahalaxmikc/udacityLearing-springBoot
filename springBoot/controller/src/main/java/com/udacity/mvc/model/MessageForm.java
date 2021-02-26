package com.udacity.mvc.model;

public class MessageForm {
    private  String text;
    private String animalName;
    private String adjective;

    public MessageForm(String text, String animalName, String adjective) {
        this.text = text;
        this.animalName = animalName;
        this.adjective = adjective;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAdjective() {
        return adjective;
    }

    public void setAdjective(String adjective) {
        this.adjective = adjective;
    }
}
