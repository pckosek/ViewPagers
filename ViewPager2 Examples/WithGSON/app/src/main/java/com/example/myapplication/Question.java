package com.example.myapplication;

public class Question {

    String type;
    String question;
    boolean answer;

    public Question() {}

    public boolean checkAnswer(boolean b) {
        if (b==answer) {
            return true;
        } else  {
            return false;
        }
    }

}
