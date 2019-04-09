package com.blacklxians.quiz.model;
import java.util.ArrayList;
public class Quiz{
    
    private String question;
    private ArrayList<String> choice;
    private String answer;

    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
   public void setChoice(ArrayList<String> choice) {
       this.choice = choice;
   }
   public ArrayList<String> getChoice() {
       return choice;
   }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public String getAnswer() {
        return answer;
    }
}