package com.igate.main;


import com.igate.entity.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class MainClass 
{
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		try{
			em.getTransaction().begin();
			Student st = new Student();
			st.setSname("Vinod Kumar");
			st.setSroll(26);
			st.setScourse("MBBS");
			em.persist(st);
			System.out.println("id="+st.getId());
			em.getTransaction().commit();
			
			em.getTransaction().begin();
			
			Student st2=em.find(Student.class,1);			
			em.remove(st2);
			
          System.out.println(" student removed ");
		}
		catch(Exception e){
		e.printStackTrace();
		}
		finally{
			em.close();
		}

	}
	

}
