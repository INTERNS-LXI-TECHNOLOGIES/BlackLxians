package com.blacklxians.quiz.controller;
import com.blacklxians.quiz.view.*;
import java.io.*;
import java.util.*;
public class LogginController
{
	Properties p=new Properties();
public String validation(String userName,String password)
{
	String result=null;
	try
	{
	
	FileReader f=new FileReader("db.properties");
	
	p.load(f);
	
if(userName.equals(p.getProperty("ausername")) && password.equals(p.getProperty("apassword")))
{
result="admin loggin";

}
else if(userName.equals(p.getProperty("username")) && password.equals(p.getProperty("password")))
{
result="user loggin";
}
else{
result="invalid";
}
	}
catch(IOException e)
{
}

return result;


}
public String registerValidation(String userName,String password)
{
	String res=null;
	try{
	
	//FileWriter fw=new FileWriter("db.properties");
	//BufferedWriter bw=new BufferedWriter(fw);
	p.setProperty("username=",userName);
	p.setProperty("password=",password);
	p.store(new FileWriter("db.properties",true),"");
	}
	catch(IOException e)
{
}
	
	return res="Registration Successfull";
	
}


}

