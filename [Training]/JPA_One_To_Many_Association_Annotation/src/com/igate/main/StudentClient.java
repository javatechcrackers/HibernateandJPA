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
	   Set<Phone> phoneNumbers = new HashSet<Phone>();
		phoneNumbers.add(new Phone("house", "32354353"));
		phoneNumbers.add(new Phone("mobile", "9889343423"));

		Student student = new Student("Eswar", phoneNumbers);
		em.persist(student);
	   
	   em.getTransaction().commit();
	   System.out.println(" Students persisted");
	   

   }
}
