package com.igate.main;

import com.igate.entity.*;
import java.util.List;
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
	   Student student=new Student();
	   student.setFirstname("Sarba");
	   student.setLastname("Singh");
	   em.persist(student);
	   
	   FulltimeStudent  fulltime=new FulltimeStudent();
	   fulltime.setFirstname("Rakesh");
	   fulltime.setLastname("Roshan");
	   fulltime.setYears(3);
	   em.persist(fulltime);
	   
	   ParttimeStudent  parttime=new ParttimeStudent();
	   parttime.setFirstname("Sachin");
	   parttime.setLastname("Tendulkar");
	   parttime.setHours(100);
	   em.persist(parttime);
	   
	   
	   
	   em.getTransaction().commit();
	   System.out.println(" Students persisted");
	   

   }
}
