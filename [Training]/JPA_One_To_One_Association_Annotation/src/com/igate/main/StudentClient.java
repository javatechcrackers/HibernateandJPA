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
	   Address address1 = new Address("SEZ", "Chennai", "TN", "600097");
		Address address2 = new Address("ITPL", "Banglore", "Karnataka", "560000");
		Student student1 = new Student("Suresh", address1);
		Student student2 = new Student("Sudeep", address2);
		em.persist(student1);
		em.persist(student2);
		
	   
	   em.getTransaction().commit();
	   System.out.println(" Students persisted");
	   

   }
}
