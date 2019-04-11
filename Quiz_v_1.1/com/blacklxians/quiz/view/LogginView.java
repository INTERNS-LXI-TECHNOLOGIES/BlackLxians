package com.blacklxians.quiz.view;
import com.blacklxians.quiz.controller.*;
import java.util.*;
import java.io.*;
public class LogginView
{
    Scanner scan=new Scanner(System.in);
	LogginController l=new LogginController();
public void display()
{
	System.out.println(" ");
	System.out.println("1.Login");
	System.out.println("2.Register");
	System.out.println(" ");
	System.out.print("Enter your choice :");
	int choice=scan.nextInt();
	switch(choice)
	{
		case 1:login();
		break;
		case 2:register();
		break;
		default:System.out.println("Invalid choice made...please try again...!!!");
		break;
	}
}

public void login()
{
String result=null;

            System.out.println("                             LOGGIN                              ");
			System.out.println("-----------------------------------------------------------------");
			System.out.println(" ");
			System.out.print("Username:");
			String userName=scan.next();
			System.out.print("Password:");
		    String password=scan.next();
			result=l.validation(userName,password);
			System.out.println(" ");
			System.out.println(result);
}

public void register()
{
	String res=null;
	
			System.out.println("                        REGISTRATION                               ");
			System.out.println("-------------------------------------------------------------------");
			System.out.println(" ");
			System.out.print("Username:");
			String userName=scan.next();
			System.out.print("Password:");
			String password=scan.next();
			Properties p=new Properties();
			res=l.registerValidation(userName,password);
			System.out.println(" ");
			System.out.println(res);
}


}