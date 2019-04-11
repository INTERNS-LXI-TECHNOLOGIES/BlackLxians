package com.blacklxians.quiz;
import com.blacklxians.quiz.controller.*;
public class Tdd
{
	public static void main(String args[])
	{
		UserController user=new UserController();
		user.setQuiz();
		user.startQuiz();

	}
}