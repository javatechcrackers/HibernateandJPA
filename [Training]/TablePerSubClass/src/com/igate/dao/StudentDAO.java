package com.igate.dao;
import com.igate.entity.*;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import com.igate.entity.Student;
import com.igate.util.HibernateUtil;

/*
 * Class Name : StudentDAO
 * 
 * Description : Implements DAO Layer methods to perform various CRUD operations. 
 *             
 *           
 */


public class StudentDAO 
{
	public void insertStudentRecords()
	{
	Session session = null;
	Transaction tx =null;
	
	try { 
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
		
		FulltimeStudent fulltimeStudent = new FulltimeStudent(); 
		fulltimeStudent.setId(3);
		fulltimeStudent.setName("Mangala");
		fulltimeStudent.setYears(4);
		
		session.save(fulltimeStudent);
		
		ParttimeStudent parttimeStudent = new ParttimeStudent(); 
		parttimeStudent.setId(4);
		parttimeStudent.setName("Vinod"); 
		parttimeStudent.setHours(100);
		session.save(parttimeStudent);
				
		tx.commit();
		System.out.println("Students inserted");
		 
		}
		catch(Exception e)
		{  
			tx.rollback(); 
		}
		finally
		{ 
		session.close();
		} 
	}
	
}
