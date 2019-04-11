package com.blacklxians.quiz;
import com.blacklxians.quiz.controller.*;
import com.blacklxians.quiz.view.ManagerView;
public class Tdd
{
	public static void main(String args[])
	{
		ManagerView mv = new ManagerView();
		mv.managerProgram();
		UserController user=new UserController();
		user.setQuiz();
		user.startQuiz();

	}
}