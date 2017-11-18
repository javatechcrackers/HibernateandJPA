package com.igate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.igate.entity.Student;
import com.igate.util.HibernateUtil;

public class Level2CacheMain 
{
	public static void main(String[] args)throws Exception
	{
		
		SessionFactory sf =HibernateUtil.getSessionFactory();		
		Session session = sf.openSession();
		session.beginTransaction();
		
	
		
		Student s=new Student();
		s.setStudentId(679L);
		s.setStudentName("Hrudanand");
		session.save(s);				
					
		session.getTransaction().commit();
		
		
		session=sf.openSession();
		Student st=(Student)session.get(Student.class,679L);
		System.out.println("name="+st.getStudentName());
		
	    session.close();
		

	System.out.println(" done");				
									
	}
	
}
