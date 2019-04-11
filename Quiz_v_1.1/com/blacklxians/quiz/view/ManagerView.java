package com.blacklxians.quiz.view;

import java.io.*;
import java.util.*;
import com.blacklxians.quiz.controller.ManagerController;
import com.blacklxians.quiz.model.Quiz;
/**

*@author:Rahul

**/

public class ManagerView{
	static Scanner scan = new Scanner(System.in);
	ManagerController manager = new ManagerController();
	public void managerProgram(){
		int temp = 0;
		do{
			int option;
			System.out.println("1.Create\n2.Select\n3.Update\n4.Delete\n5.Add");
			option = scan.nextInt();
			switch(option){
				case 1:
				addQuiz();
				break;
				case 2:
				quizSelect();
				readView();
				break;
				case 3:
				
				int opt = 0;
				do{
					quizSelect();
					readView();
					System.out.println("\nSelect");
					int sc = scan.nextInt();
					System.out.println("\nSelet the Part to edit\n 1.Question\n 2.Options\n 3.Answer");
					int section = scan.nextInt();
					manager.update();
					System.out.println("1.Update again\nPress enter to exit");
					opt = scan.nextInt();
				}while(opt == 1);
				break;
				case 4:
				deleteQuiz();
				break;
				case 5:
				int opt2 = 0;
				do{
					quizSelect();
					manager.add();
					System.out.println("1.Add again\nPress enter to exit");
					opt2 = scan.nextInt();
				}while(opt2 == 1);
				default:
				//LoginView l = new LoginView();
				//l.display();
				break;

			}
			System.out.println("1.Admin \n2.Logout");
			temp = scan.nextInt();
			manager.getQuizs().clear();
			/*if(temp==2){
				LoginView l = new LoginView();
				l.display();
			}*/
		}
		while(temp==1);
	}
	public void readView(){
		ArrayList<Quiz> quizs = manager.read();
		for(int i=0;i<quizs.size();i++){
			System.out.println("("+(i+1)+")"+quizs.get(i).getQuestion());
			for(int j=0;j<4;j++){
				System.out.println((j+1)+"."+quizs.get(i).getOptions()[j]);
			}
			System.out.println("Answer : "+quizs.get(i).getAnswer()+"\n");
		}
	}
	public void quizSelect(){
		System.out.println("Select Quiz\n");
		List<String> quizs = manager.getQuiz();
		for(int i = 0;i<quizs.size();i++){
			System.out.println((i+1)+"."+quizs.get(i));
		}
		int temp = scan.nextInt();
		manager.quiz(temp);
	}
	public void addQuiz(){
		System.out.println("Enter Quiz Session");
		String name = scan.next();
		manager.create(name);
		System.out.println("File Created Successfully");
	}
	public void deleteQuiz(){
		System.out.println("1.Delete QuizSession\n2.Delete Quiz");
		int temp = scan.nextInt();
		int opt=0;
		if(temp==2){
			
			do{
				quizSelect();
				readView();
				System.out.println("\nSelect from above");
				int sc = scan.nextInt();
				manager.delete();
				System.out.println("1.Delete More\nPress any key to exit");
				opt = scan.nextInt();
				manager.getQuiz().clear();
			}while(opt == 1);
			System.out.println("Deleted Sucessfully");
		}
		else if(temp==1){
			System.out.println("Select Quiz From Below\n");
			List<String> quizs = manager.getQuiz();
			for(int i = 0;i<quizs.size();i++){
				System.out.println((i+1)+"."+quizs.get(i));
			}
			int a = scan.nextInt();
			manager.deleteQuizSession(a);
			System.out.println("Quiz Session deleted successfully");
		}
	}
}
