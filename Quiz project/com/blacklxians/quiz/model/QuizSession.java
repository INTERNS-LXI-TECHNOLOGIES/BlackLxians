package com.blacklxians.quiz.model;
import java.util.*;
public class QuizSession
{
	private String qustions;
	private String[] options;
	private String answers;
	public void setQustions(String qustions)
	{
		this.qustions=qustions;
	}
	public void setAnswers(String answers)
	{
		this.answers=answers;
	}
	public void setOptions(String [] options)
	{
		this.options=options;
	}
	public String getQustions()
	{
		return qustions;
	}
	public String getAnswers()
	{
		return answers;
	}
	public String[] getOptions()
	{
		return options;
	}
}