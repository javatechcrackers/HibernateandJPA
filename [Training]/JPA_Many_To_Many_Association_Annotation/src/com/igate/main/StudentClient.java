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
	   Set<Course> courses = new HashSet<Course>();
		courses.add(new Course("Spring"));
		courses.add(new Course("Struts"));

		Student student1 = new Student("Naveen", courses);
		Student student2 = new Student("Sudeep", courses);
		em.persist(student1);
		em.persist(student2);

	   em.getTransaction().commit();
	   System.out.println(" Students persisted");
	   

   }
}
