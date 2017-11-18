package com.igate.dao;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import com.igate.entity.Student;
import com.igate.util.HibernateUtil;
/*
 * Class Name  : StudentDAO
 * 
 * Description : The DAO class defines addStudent(student) method which creates
 *               the Hibernate Session object from HibernateSessionFactory
 *               and calls session.save(student) to persist the entity into database.
 *               Upon successful insertion of the record the method addStudent(student) returns 
 *               the id or else returns 0 to the BO layer upon exception .  
 */

public class StudentDAO {
	
	Session session=null;
	Transaction transaction=null;
	
	public int addStudent(Student student)
	{
		int studentID=0;
		try
		{
		session=HibernateUtil.getSessionFactory().openSession();
		transaction=session.beginTransaction();
		
		//save method persists the Student object as one record in the table
		
		studentID=(Integer)session.save(student); 
		transaction.commit();		
		}
		catch(HibernateException hibernateException)
		{
			if(transaction!=null)
			{
				transaction.rollback();
				studentID=0;
			}
		}
		return studentID;
	}

	
	
	
}
