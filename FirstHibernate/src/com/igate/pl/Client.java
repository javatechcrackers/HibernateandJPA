package com.igate.pl;

import java.util.ArrayList;
import java.util.List;

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
	Client client= new Client();
	
	Student student=new Student();
	student.setStudentId(32);
	student.setStudentMarks(99.9);
	student.setStudentName("Veena");
			
	int studentID=studentBO.addStudent(student);
	int studentID1= studentBO.addStudent(client.getAllStudent());
	if(studentID>0 || studentID1 > 0){
			System.out.println("Student Added successfully and the student id is: "+studentID);
			System.out.println("Student Added successfully and the student id is: "+studentID1);
	}else
			System.out.println("Adding Student failed");		
      
	}
	 
	public List<Student> getAllStudent(){
	
	List<Student> stdList = new ArrayList<Student>();
	
	for(int i=33; i <36 ;i++){
		Student s = new Student();
		s.setStudentId(i);
		s.setStudentMarks(70+i);
		s.setStudentName("pkk" + i);
		stdList.add(s);
	}
	return  stdList;
	}
}
