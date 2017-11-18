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
public class JPADelete {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPACRUDApplication");
		EntityManager em = emf.createEntityManager();
		try{
			em.getTransaction().begin();
			//find 
			Student stud1 =  em.find(Student.class,1);
			//delete
			em.remove(stud1);
			em.getTransaction().commit();
			System.out.println(" Student deleted successfully");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		finally{
			em.close();
		}
	}

}
