package com.blacklxians.quiz.view;
import com.blacklxians.quiz.controller.*;
import com.blacklxians.quiz.model.*;
import java.util.*;
import java.io.*;

/**
  
  
 *@author:Akhil 
 
  
 **/


public class QuizView
{
	Scanner in = new Scanner(System.in);

	public int viewQuiz()
	{

		System.out.println("Welcome To the Quiz");

		System.out.println("Enter your Choice \n 1.Science \n 2.Genereal Questions");
		
		

		return in.nextInt();
	}

	public int displayQuiz(Quiz quiz)
	 {
	 	System.out.println(quiz.getQuestion());

	 	String [] options= quiz.getOptions();
	 	for(int i=0;i<4;i++)
	 	{
	 		System.out.println(options[i]);
	 	}
	 	System.out.println("Enter your Answer");
		return in.nextInt();
		
	}
	public void displayScore(int mark)
	{
	 System.out.println("Your Mark"+mark);
	}

}