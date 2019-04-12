package com.blacklxians.quiz.controller;
import com.blacklxians.quiz.view.*;
import java.io.*;
import java.util.*;
public class LogginController
{
	Properties p=new Properties();
public String validation(String userName,String password)
{
	String result="invalid";
	try
	{
	
	FileReader f=new FileReader("db.properties");
	
	p.load(f);
	
if(userName.equals(p.getProperty("ausername")) && password.equals(p.getProperty("apassword")))
{
result="admin loggin";
}
else
{
//result="user loggin";
int count=count();
	count=count-2;
	count=count/4;
for(int i=0;i<count;i++)
{
	if(userName.equals(p.getProperty("username"+i)) && password.equals(p.getProperty("password"+i)))
	   result="user loggin";
   
}
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
	int count=count();
	count=count-2;
	count=count/4;
	try{
	
	//FileWriter fw=new FileWriter("db.properties");
	//BufferedWriter bw=new BufferedWriter(fw);
	p.setProperty("username"+count,userName);
	p.setProperty("password"+count,password);
	p.store(new FileWriter("db.properties",true),"");
	}
	catch(IOException e)
{
}
	
	return res="Registration Successfull";
	
}

public int count()
{
	int count=0;
	try{
		FileReader fr=new FileReader(new File("db.properties"));
		BufferedReader br=new BufferedReader(fr);
		String data;
		while((data=br.readLine())!=null)
		{
			count++;
		}
	}
	catch(Exception e){
	}

return count;
}

}