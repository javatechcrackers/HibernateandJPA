package com.igate.main;
import com.igate.entity.*;

import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StudentClient 
{

   public static void main(String args[])
   {	   	   
 
	   EntityManagerFactory emf=Persistence.createEntityManagerFactory("JPAEntityPU");
	   EntityManager em=emf.createEntityManager();
	   em.getTransaction().begin();
	 
	   
	   Student student = new Student();
	    student.setName("Sudip");
	    em.persist(student);
	    
	    Student student1 = new Student();
	    student1.setName("Naveen");
	    em.persist(student1);
	    
	    
	    
	    Department dept = new Department();
	    dept.setName("Computer Scince");
	    student.setDepartment(dept);
	    student1.setDepartment(dept);
	    
	    em.flush();	    	    
	    Set set=new HashSet();
	   
	    
	    
	    
	    
	   
	   em.getTransaction().commit();
	   System.out.println(" Students persisted");
	   

   }
}
