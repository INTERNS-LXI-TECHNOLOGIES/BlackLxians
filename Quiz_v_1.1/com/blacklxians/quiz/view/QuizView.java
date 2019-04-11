package com.blacklxians.quiz.view;
import com.blacklxians.quiz.controller.*;
import com.blacklxians.quiz.model.*;
import java.util.*;
import java.io.*;
public class QuizView
{

	Scanner in = new Scanner(System.in);

	public int viewQuiz()
	{

		System.out.println("\n\t\t______________Welcome To the Quiz________________");

		System.out.println("\n\t\t\tEnter your Choice \n\t\t\t 1.Science \n\t\t\t 2.General Questions \n\t\t\t 3.Geography Questions");
		
		

		return in.nextInt();
	}

	public int displayQuiz(QuizSession quiz)
	 {
	 
	 	System.out.println("  ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"
	 		               +"\n"+" "+quiz.getQuestion());

	 	String [] options= quiz.getOptions();
	 	
	 	for(int i=0;i<4;i++)
	 	{

	 		System.out.println(options[i]);
	 	}
	 	int b;

	 	 do{
	 	 	  System.out.println("\nEnter your Answer");
	     	  b=in.nextInt();
	 		 if(b>=5)
	 		 {
	 			System.out.println("invalid option try agine");
        	 	
        	 }
        	}
         while( b>=5);
         return b;

	}
	public void displayScore(int mark)
	{
	 System.out.println("Your Mark "+mark +"!");

	 System.out.println("\n\nPress 0 to continue the Quiz...\nPress 1 To Exit Quiz ");

	 int a= in.nextInt();
	 if(a==0)
	 {
	 	viewQuiz();
	 }
	 

	}

}