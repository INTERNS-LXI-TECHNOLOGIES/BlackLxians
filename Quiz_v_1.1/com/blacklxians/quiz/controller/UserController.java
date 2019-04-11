package com.blacklxians.quiz.controller;
import com.blacklxians.quiz.model.*;
import com.blacklxians.quiz.view.*;
import java.util.*;
import java.io.*;
public class UserController
{
	QuizView quizview = new QuizView();

	ArrayList<QuizSession> quizes = new ArrayList<QuizSession>();

	public void setQuiz()
	{
		String fileName=null;

		int ch = quizview.viewQuiz();
		
		switch(ch)
		{
			case 1:
			fileName = "file";
			break;
			case 2:
			fileName = "file1";
			break;
			case 3:
			fileName="file2";
			break;
			default :
			System.out.println("invalid Option");
			break;
		}


		

		File f=new File("Prop.properties");
		Properties prop = new Properties();
		try	
		{
			prop.load(new FileInputStream(f));
			String a = prop.getProperty(fileName);
			File file = new File(a);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line ;
			while((line=br.readLine())!=null)
			{
				String[] sp = line.split(",");

				QuizSession quiz = new QuizSession();
				quiz.setQuestion(sp[0]);
				String [] opt= new String[4];
				for(int i=1;i<5;i++)
					{
						opt[i-1] = sp[i]; 
					  
					}
					quiz.setOptions(opt);
				quiz.setAnswer(sp[5]);
				quizes.add(quiz);
			}	
		}
		catch(NullPointerException e)
		{
		
		}
		catch(Exception e)
		{
			e.printStackTrace();

		}

		
		}

		public void startQuiz() 
		{
			int opt,count=0;
			String optValue=null;

			for(int i=0;i<quizes.size();i++) 
			{

				opt = quizview.displayQuiz(quizes.get(i));

				optValue = quizes.get(i).getOptions()[opt-1];
				System.out.println("*"+"AnsWer is  "+quizes.get(i).getAnswer().equals(optValue)+"!");

				if(quizes.get(i).getAnswer().equals(optValue))
				 {


					count++;
				}  
   				

			}
			quizview.displayScore(count);

		}
		


}
