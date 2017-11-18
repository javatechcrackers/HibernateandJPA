package com.igate.dao;

import java.util.*;
import java.sql.*;
import org.hibernate.*;
import com.igate.util.*;
import com.igate.entity.Student;


public class StudentDAO
{
    
	 Session session = HibernateUtil.getSessionFactory().openSession(); 
	 
	 
	  /* The method creates a query with  filter enabled and  setting the 
	    gender filter parameter to "Female" */
	    
	   
	 public void simpleQueryFilter()
	 { 
		prepareTestData();   // Creates new records in table
		
		Filter filter =session.enableFilter("genderFilter");
		filter.setParameter("genderParam", "Female");
		Query query= session.createQuery("FROM Student");
		List list=query.list();		
		
		displayStudentsList(list);  // Displaying students
	
		 
	 }
      
        
    
         // Below are utility methods    
         public  void displayStudentsList(List list)
         {
        	 Iterator iter = list.iterator();
        	 if (!iter.hasNext()){
        		 System.out.println("No students to display.");
        		 return;
        	 }
        	 while (iter.hasNext()){
        		 Student student = (Student) iter.next();
        		 String msg = student.getStudentId() + "\t";
        		 msg += student.getStudentName() + "\t";
        		 msg += student.getStudentMarks() ;
        		 System.out.println(msg);
        	 }
         }
    
   
    
         public void prepareTestData()
         {
        	 Session session = HibernateUtil.getSessionFactory().openSession();
        	 Transaction tx = session.beginTransaction();
        	 
        	 Student student1=new Student();
        	 student1.setStudentId(1);
        	 student1.setStudentName("Prakash");
        	 student1.setStudentMarks(99.4);
        	 student1.setGender("Male");
        	 session.save(student1);
        
        	 Student student2=new Student();
        	 student2.setStudentId(2);
        	 student2.setStudentName("Sudhakar");
        	 student2.setGender("Male");
        	 student2.setStudentMarks(97.5);
        	 session.save(student2);
        
        
        	 Student student3=new Student();
        	 student3.setStudentId(3);
        	 student3.setStudentName("Pooja");
        	 student3.setStudentMarks(93.6);
        	 student3.setGender("Female");
        	 session.save(student3);
        
        
        	 Student student4=new Student();
        	 student4.setStudentId(4);
        	 student4.setStudentName("Rashmi");
        	 student4.setStudentMarks(92.8);
        	 student4.setGender("Female");
        	 session.save(student4);
        
        
        	 Student student5=new Student();
        	 student5.setStudentId(5);
        	 student5.setStudentName("Karthik");
        	 student5.setStudentMarks(89.4);
        	 student5.setGender("Male");
        	 session.save(student5);
                        
        	 Student student6=new Student();
        	 student6.setStudentId(6);
        	 student6.setStudentName("Karthik");
        	 student6.setStudentMarks(45.4);
        	 student6.setGender("Male");
        	 session.save(student6);
        	 
	  
     
        	 tx.commit();
        	 session.close();
        	 
        }
}