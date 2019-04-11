package com.blacklxians.quiz.model;
import java.util.*;
/**
  
  
 *@author:Akhil 
 
 */

public class Quiz
{
	private String question;
	private String[] options;
	private String answer;
	public void setQuestion(String question)
	{
		this.question=question;
	}
	public void setAnswer(String answer)
	{
		this.answer=answer;
	}
	public void setOptions(String [] options)
	{
		this.options=options;
	}
	public String getQuestion()
	{
		return question;
	}
	public String getAnswer()
	{
		return answer;
	}
	public String[] getOptions()
	{
		return options;
	}
	
}
