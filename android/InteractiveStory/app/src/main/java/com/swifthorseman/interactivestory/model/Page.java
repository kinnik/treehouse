package com.swifthorseman.interactivestory.model;


public class Page {
    private int imageId;
    private String text;
    private Choice choice1, choice2;
    private boolean isFinal;

    public Page(int imageId, String text, Choice choice1, Choice choice2) {
        this.imageId = imageId;
        this.text = text;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.isFinal = false;
    }

    public Page(int imageId, String text) {
        this.imageId = imageId;
        this.text = text;
        this.isFinal = true;
    }


    public boolean isFinal() {
        return isFinal;
    }

    public void setFinal(boolean isFinal) {
        this.isFinal = isFinal;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Choice getChoice1() {
        return choice1;
    }

    public void setChoice1(Choice choice1) {
        this.choice1 = choice1;
    }

    public Choice getChoice2() {
        return choice2;
    }

    public void setChoice2(Choice choice2) {
        this.choice2 = choice2;
    }

}
