package com.blacklxians.quiz.controller;

import java.io.*;
import java.util.ArrayList;

import com.blacklxians.quiz.model.Quiz;
import com.blacklxians.quiz.view.QuizView;

public class QuizController{
    
    QuizView qv = new QuizView();
    ArrayList<Quiz> quiz = new ArrayList<Quiz>();
    
    
    public void start(){
        try{
            File file = new File("quiz.csv");
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String data;
                while((data= br.readLine())!= null){
                    String[] a = data.split(",");
        
        Quiz q = new Quiz();
        
        q.setQuestion(a[0]);
        
        ArrayList<String> choices=new ArrayList<String>();

        for(int i=1;i<=3;i++){
        
            choices.add(a[i]);
           
        }

        q.setChoice(choices);
        q.setAnswer(a[4]);
        quiz.add(q);    
    }
    
    
    qv.display(quiz);
}catch(Exception e){
    System.out.println(e);
}
}
}

//p v admin(str name,str pass)    
