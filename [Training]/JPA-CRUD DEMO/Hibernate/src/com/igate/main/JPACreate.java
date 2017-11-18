/**
 * 
 */
package com.igate.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.igate.entity.Student;

/**
 * @author Administrator
 *
 */
public class JPACreate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPACRUDApplication");
		EntityManager em = emf.createEntityManager();
		System.out.println("entitymanager created");
		try{
			em.getTransaction().begin();
			Student st = new Student();
			st.setSname("Vinod Kumar");
			st.setSroll(25);
			st.setScourse("MBBS");
			em.persist(st);//insert 
			em.getTransaction().commit();
			System.out.println(" New student created");
		}
		catch(Exception e){
		e.printStackTrace();
		}
		finally{
			em.close();
		}

	}

}
