package com.igate.pl;

import com.igate.bo.StudentBO;
import com.igate.entity.Student;

/* Class Name :Client.java
 * 
 * Description : This is the Main Client class which instantiates a Student entity,
 *               populates the instance with values using setter methods and calls the BO method
 *               addStudent(student)to persist a new student into the database  
 */

public class Client {
	
	public static void main(String[] ar)
	{
		
	StudentBO studentBO=new StudentBO();
	
	Student student=new Student();
	student.setStudentId(37);
	student.setStudentMarks(99.9);
	student.setStudentName("Veena");
			
	int studentID=studentBO.addStudent(student);
	
	if(studentID>0)
			System.out.println("Student Added successfully and the student id is: "+studentID);
	else
			System.out.println("Adding Student failed");		
      
	}
}
