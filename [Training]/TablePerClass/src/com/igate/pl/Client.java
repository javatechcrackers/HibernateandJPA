package com.igate.pl;

import java.util.Scanner;
import com.igate.dao.*;
import com.igate.entity.Student;


public class Client 
{
	
	public static void main(String[] ar)
	{
		StudentDAO studentdao=new StudentDAO();
		studentdao.insertStudentRecords();		
		
		
	}

}
