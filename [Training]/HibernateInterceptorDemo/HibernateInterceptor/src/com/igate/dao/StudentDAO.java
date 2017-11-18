package com.igate.dao;

import java.util.*;
import java.sql.*;
import org.hibernate.*;
import com.igate.util.*;
import com.igate.entity.Student;


public class StudentDAO
{
    
	 Session session = HibernateUtil.getSessionFactory().openSession(); 
	 	 	 	   
	 public void CreateStudent()
	 { 
		 
		    LoggerInterceptor interceptor = new LoggerInterceptor();
			session = HibernateUtil.getSessionFactory().openSession(interceptor);
			interceptor.setSession(session);	
			
			// persisting student instance to invoke onSave() callback interceptor method
			session.beginTransaction();
			Student student=new Student();
			student.setStudentId(1);
			student.setStudentName("Sarba");
			student.setStudentMarks(99.99);
			student.setGender("Male");
			session.save(student);
			session.getTransaction().commit();
			
			// Deleting student instance to invoke onDelete() callback 	interceptor method		
			session.beginTransaction();
			Student s=(Student)session.get(Student.class,1);
			session.delete(s);
																	 
	 }
                  
       
}