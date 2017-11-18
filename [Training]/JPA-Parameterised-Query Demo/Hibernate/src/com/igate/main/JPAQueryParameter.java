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
import javax.persistence.TypedQuery;

import com.igate.entity.Student;

public class JPAQueryParameter 
{

	
	public static void main(String[] args) 
	{
	

		
		EntityManager em;
		
		 try
		 {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPACRUDApplication");
		    em = emf.createEntityManager();				
			em.getTransaction().begin();
			
			//---------- Inserting records into Student table -------------
			
			Student st = new Student();
			st.setSname("Vinod Kumar");
			st.setSroll(25);
			st.setScourse("MBBS");			
			em.persist(st);
			
			st=new Student();
			st.setSroll(26);
			st.setSname("Mohan Kumar");
			st.setScourse("Java");
			em.persist(st);
			
			st=new Student();
			st.setSroll(27);
			st.setSname("Prakash Kumar");
			st.setScourse("C# ");
			em.persist(st);
			
			
			st=new Student();
			st.setSroll(28);
			st.setSname("Muniraj Kumar");
			st.setScourse("VC++");
			em.persist(st);
			
			
			
			
			em.getTransaction().commit();
			System.out.println(" New students created");
		 
		 
		 
			
		
			//------------Select all the record from student table----------		
	        Query query = em.createQuery("SELECT st FROM Student st");
	        
	        List lst = query.getResultList();
			Iterator it = lst.iterator();
			System.out.println(" ================Printing all records from Student Table================= ");
			while (it.hasNext()){
				Student student = (Student) it.next();
				System.out.print("Id:"+student.getId());
				System.out.print(" Name:"+student.getSname());
				System.out.println(" Course:"+student.getScourse());
			}
			
			
			
			//---------- query  with Named parameters ----------------
			
			 Query query2 = em.createQuery("SELECT st FROM Student st where st.sroll=:roll",Student.class);
			 query2.setParameter("roll",25);
			 Student s=(Student)query2.getSingleResult();
			 System.out.println("================Named Parameter Example Query Result=================");
			 System.out.println("Student Name= "+s.getSname()+"Student Course="+s.getScourse());
			 			 			 	
			 
			 
			 //------------- Query with Ordinal Parameter-----------------
			 
			 
			 TypedQuery<Student> query3=em.createQuery("SELECT st FROM Student st WHERE st.sroll=?1",Student.class);
			 query3.setParameter(1,28);
			 Student s2=query3.getSingleResult();
			 System.out.println("================Ordinal Parameter Example Query Result=================");
			 System.out.println("Student Name= "+s2.getSname()+"Student Course="+s2.getScourse());
			 			 			 				 	 			 			 			 			 			 			 		
			 
			 
			em.getTransaction().commit();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		finally{
			
		}
		
		 
	}

}
