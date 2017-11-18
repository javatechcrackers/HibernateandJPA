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
			st.setScourse("VC++");			
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
			st.setSroll(30);
			st.setSname("Muniraj");
			st.setScourse("Math");
			em.persist(st);
			

			st=new Student();
			st.setSroll(31);
			st.setSname("Muniraj");
			st.setScourse("VC++");
			em.persist(st);
			
			
			
			
			em.getTransaction().commit();
			System.out.println(" New students created");
		 
		 
		 
			
		
			//------------Select all the record from student table----------		
	        Query query = em.createNamedQuery("FindAllStudents");
	        
	        List lst = query.getResultList();
			Iterator it = lst.iterator();
			System.out.println(" ================Printing all records from Student Table================= ");
			while (it.hasNext()){
				Student student = (Student) it.next();
				System.out.print("Id:"+student.getId());
				System.out.print(" Name:"+student.getSname());
				System.out.println(" Course:"+student.getScourse());
			}
			
			
			
			//============== Select all students whose name is Muniraj ==================
			
			 List lst2= em.createNamedQuery("FindAllStudentsByName")
			             .setParameter("name","Muniraj")
			             .getResultList();		
			 
				Iterator it2 = lst2.iterator();
				System.out.println(" ================Printing all Students with name Muniraj================= ");
				while (it2.hasNext()){
					Student student = (Student) it2.next();
					System.out.print("Id:"+student.getId());
					System.out.print(" Name:"+student.getSname());
					System.out.println(" Course:"+student.getScourse());
				}
			
				
				

				//============== Select all students who have joined VC++ ==================
				
				 List lst3= em.createNamedQuery("FindAllStudentsByCourse")
				             .setParameter("course","VC++")
				             .getResultList();		
				 
					Iterator it3 = lst3.iterator();
					System.out.println(" ================Printing all Students who have joined for VC++================= ");
					while (it3.hasNext()){
						Student student = (Student) it3.next();
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
			
		}
		
		 
	}

}
