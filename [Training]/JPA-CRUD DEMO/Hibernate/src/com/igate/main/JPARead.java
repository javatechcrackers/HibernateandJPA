/**
 * 
 */
package com.igate.main;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.igate.entity.Student;
/**
 * @author Administrator
 *
 */
public class JPARead {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPACRUDApplication");
		EntityManager em = emf.createEntityManager();
		try{
			em.getTransaction().begin();
			//Select all the record from student table
	        Query query = em.createQuery("SELECT st FROM Student st");
	        List lst = query.getResultList();
			Iterator it = lst.iterator();
			while (it.hasNext()){
				Student student = (Student) it.next();
				System.out.print("Id:"+student.getId());
				System.out.print(" Name:"+student.getSname());
				System.out.println(" Course:"+student.getScourse());
			}
			em.getTransaction().commit();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		finally{
			em.close();
		}
	}

}
