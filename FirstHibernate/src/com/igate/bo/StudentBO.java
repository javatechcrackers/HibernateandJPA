package com.igate.bo;

import java.util.List;

import com.igate.dao.StudentDAO;
import com.igate.entity.Student;

/*
 * Class Name: StudentBO
 * Description : The BO class defines the business method addStudent(student)
 *               which accepts the student entity from client and calls the dao method
 *               to perform insert operation into the database
 *                             
 */

public class StudentBO {
	
	StudentDAO studentDAO=null;
	
	public int addStudent(Student student)
	{		
	    studentDAO=new StudentDAO();
		int studentID=studentDAO.addStudent(student);
		return studentID;
		
	}

	public int addStudent(List<Student> allStudent) {
		 	studentDAO=new StudentDAO();
			int studentID=studentDAO.addStudent(allStudent);
			return studentID;
	}
	
}
