package com.blacklxians.quiz.controller;
import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Properties;

import com.blacklxians.quiz.model.Quiz;
/**


*@author:Rahul



**/
public class ManagerController{
	
	File f = new File("Prop.properties");
        
    private ArrayList<Quiz> quizs = new ArrayList<Quiz>();
    Scanner scan = new Scanner(System.in);
    public ArrayList<Quiz> getQuizs(){
        return quizs;
    }
    public void quiz(int dSelect){
    Properties prop = new Properties();
    try{
        prop.load(new FileReader("Prop.properties"));

    }catch(Exception e){}
    File f = new File(prop.getProperty("filename"+dSelect));
}
    public void create(String filename){
        int score = 0;
        try{
		
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        while(br.readLine() != null){
            score++;
		}
		
    }catch(IOException e){}
    Properties p = new Properties();
    p.setProperty(" "+((score-2)/2+1),filename);
    p.setProperty("filename"+((score-2)/2+1),filename+".csv");
    try{
		p.store(new FileWriter(f), "comments");
        
        File file = new File(filename+".csv");
			file.createNewFile();
			//deleteQuizSession(100);
		}catch(IOException e){

		}

	}
	public ArrayList<Quiz> read(){
		
		String data;
		try{
			FileReader fR = new FileReader(f);
			BufferedReader bR = new BufferedReader(fR);
			while((data = bR.readLine())!= null){
	   			String[] split = data.split(",");
	   			Quiz quiz = new Quiz();
	   			quiz.setQuestion(split[0]);
	   			String[] options = new String[4];
	   			for(int i=0;i<4;i++){
	   				options[i] = split[i+1];
	   			}
	   			quiz.setOptions(options);
	   			quiz.setAnswer(split[5]);
	   			quizs.add(quiz);
   			}
   		}catch(FileNotFoundException e){

     	}
    	catch(IOException e){
        
     	}
     	return quizs;

	}
	public void update(){
		int choice = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do{
			System.out.println("\nSelect from above");
			int sc = scan.nextInt();
			System.out.println("\nSelect the section to edit\n 1.Question\n 2.Choices\n 3.Answer");
			int ch = scan.nextInt();
			switch(ch){
				case 1:
				System.out.println("Enter new Question");
				try{
					quizs.get(sc).setQuestion(br.readLine());
				}
				catch(IOException e){

				}
				break;
				case 2:
				System.out.println("Enter new Choices");
				String[] choices = new String[4];
				for(int i=0;i<4;i++){
					System.out.print((i+1)+".");
					choices[i] = scan.next();
					System.out.print("\n");
				}
				quizs.get(sc).setOptions(choices);
				case 3:
				System.out.println("Enter new Answer");
				quizs.get(sc).setAnswer(scan.next());
			}
			write();
			System.out.println("1.Update More\nPress any key to exit");
		}while(choice == 1);
		
	}
	public void delete(){
		int choice = 0;
		do{
			System.out.println("\nSelect from above");
			int sc = scan.nextInt();
			quizs.remove(sc-1);
			write();
			System.out.println("1.Delete More\nPress any key to exit");
			choice = scan.nextInt();
		}while(choice == 1);

	}
	public void add(){
		read();
		int choice;
		do{
			String[] choices = new String[4];
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
           Quiz quiz = new Quiz();
			System.out.println("Enter Question");
			try{
				quiz.setQuestion(br.readLine());
			}
			catch(IOException e){

			}
			System.out.println("Enter Options");
			for(int i=0;i<4;i++){
					System.out.print((i+1)+".");
					choices[i] = scan.next();
					System.out.print("\n");
				}
			quiz.setOptions(choices);
			System.out.println("Enter Answer");
			quiz.setAnswer(scan.next());
			quizs.add(quiz);
			write();
			System.out.println("1.Add More\nPress any key to exit");
			choice = scan.nextInt();
		}while(choice == 1);

	}
	public void write(){
		 
		try{
			FileWriter fw = new FileWriter(f);
			BufferedWriter	bw = new BufferedWriter(fw);
			for(int i=0;i<quizs.size();i++){
			bw.write(quizs.get(i).getOptions()[i]);
			}
		bw.close();
		}
		catch(IOException e){

		}
	}
	public List<String> getQuiz(){
		Properties p = new Properties();
		List<String> quizs = new ArrayList<String>();
		try{
			p.load(new FileReader("Prop.properties"));
		}catch(Exception e){

		}
		for(int i = 1;i<11;i++){
			if(p.getProperty("quizname"+i) != null){
				quizs.add(p.getProperty("quizname"+i));
			}
		}
		return quizs;
	}
	public void deleteQuizSession(int selectQuiz){
		File file = new File("Prop.properties");
		Properties p = new Properties();
		try{
			p.load(new FileReader("Prop.properties"));
		}
		catch(Exception e){

		}
		String fileName = p.getProperty("filename"+selectQuiz);
		p.remove("filename"+selectQuiz);
		p.remove("quizname"+selectQuiz);
		try{
			p.store(new FileWriter(file),"");
		}catch(IOException e){

		}
		if(selectQuiz!=100){
			File removeFile = new File(fileName);
			removeFile.delete();
		}
	}
 
    

    
}
