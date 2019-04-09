package com.blacklxians.quiz.view;
import com.blacklxians.quiz.model.Quiz;
import java.util.*;
public class QuizView{
   
    int score;
    public void display(ArrayList<Quiz> quiz){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("~~~~~~~Welcome to the Quiz Game~~~~~~~~");
        for(Quiz qui:quiz){
            System.out.println(qui.getQuestion());
           
       

            for(String cho:qui.getChoice()){
                System.out.println(cho);
            }
            
            String ans = sc.next();
            System.out.println("\n");
            
            if(ans.equals(qui.getAnswer())){
                score++;
            }
            
            
        }
        
        System.out.println("Score:"+score);                                                                 //Admincontroller a = new Admincontroller();
                                                                       //a.adminv(name,pass);  

   
    
    }
}