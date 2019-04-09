package com.blacklxians.quiz.model;
import java.util.*;
public class QuizSession
{
	private String questions;
	private String[] options;
	private String answers;
	public void setQuestions(String questions)
	{
		this.questions=questions;
	}
	public void setAnswers(String answers)
	{
		this.answers=answers;
	}
	public void setOptions(String [] options)
	{
		this.options=options;
	}
	public String getQuestions()
	{
		return questions;
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