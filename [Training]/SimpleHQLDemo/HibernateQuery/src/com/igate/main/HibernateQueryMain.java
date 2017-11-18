package com.igate.main;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.igate.entity.Student;
import com.igate.util.HibernateUtil;

public class HibernateQueryMain 
{
	static SessionFactory sf =HibernateUtil.getSessionFactory();
	
	public static void populateRecords()
	{
		// Populating table with records
	
						
		Session session = sf.openSession();
		session.beginTransaction();
		
		Student s=new Student();		
		s.setSroll(34);
		s.setSname("Madhu");
		s.setScourse("Ajax");
	
		
		Student s2=new Student();		
		s2.setSroll(35);
		s2.setSname("Vinod");
		s2.setScourse("Java");
	
		
		Student s3=new Student();		
		s3.setSroll(36);
		s3.setSname("Prakash");
		s3.setScourse("Ajax");
	
		
		Student s4=new Student();		
		s4.setSroll(37);
		s4.setSname("Akash");
		s4.setScourse("Ajax");
		
		Student s5=new Student();		
		s5.setSroll(38);
		s5.setSname("Srini");
		s5.setScourse("Java");
	
	
		
		session.save(s);
		session.save(s2);
		session.save(s3);
		session.save(s4);
		session.save(s5);
		
		session.getTransaction().commit();			
	    session.close();
	    
	}
	public static void showQueryResult(String queryString)
	{
								
		Session session = sf.openSession();
		session.beginTransaction();
		 Query query = session.createQuery(queryString);
		    List results = query.list();
		    	    
		    Iterator it=results.iterator();
		 
		    while(it.hasNext())
		    {
		    	
		    	Student student=(Student)it.next();
		    	System.out.print(" Roll="+student.getSroll());
		    	System.out.print(" Name="+student.getSname());
		    	System.out.println(" Course="+student.getScourse());
		    	
		    }
		session.close();
		
		
	}
	public static void main(String[] args)throws Exception
	{
		
	    // Populating table with sample records to be retrieved in HQL query 
	    populateRecords();
	    
	    // FROM Clause HQL Example    
	    String hql = "FROM Student";
	    System.out.println(" ========== Output for HQL Query : FROM Student ============");
	    showQueryResult(hql);
	    
	    
	    // AS Clause HQL Example	    
	    hql="FROM Student as S";	    
	    System.out.println(" ========== Output for HQL Query : FROM Student As S ============");
	    showQueryResult(hql);
	   
		
	    
	    
	    // SELECT Clause HQL Example	    
	    hql="SELECT s.sname FROM Student s";	    
	    System.out.println(" ========== Output for HQL Query : SELECT s.sname FROM Student s ============");
		Session session = sf.openSession();
		session.beginTransaction();
		 Query query = session.createQuery(hql);
		    List results = query.list();		    	    
		    Iterator it=results.iterator();
		 
		    while(it.hasNext())
		    {
		    	
		    	String sname=(String)it.next();
		    	System.out.println(" Name ="+sname);
		    	
		    }
		  
		   
		   
		   
		   
		   

		    
		    // WHERE Clause HQL Example	    
		    hql=" FROM Student s WHERE s.sname='Madhu'";	    
		    System.out.println(" ========== Output for HQL Query : FROM Student s WHERE s.sname='Madhu'============");					
		    showQueryResult(hql);
		    
		    
		    
		    
		    // ORDER BY Clause HQL Example
		    hql = "FROM Student S WHERE S.sroll > 10 ORDER BY S.sname DESC";
		    System.out.println(" ========== Output for HQL Query : FROM Student S WHERE S.sroll > 10 ORDER BY S.sname DESC============");					
		    showQueryResult(hql);
		    
		    
		    
		    //GROUP BY Clause HQL Example
		    hql= "SELECT COUNT(S.sroll), S.scourse FROM Student S GROUP BY S.scourse";
		    System.out.println(" ========== Output for HQL Query : SELECT COUNT(S.roll), S.sname FROM Student S GROUP BY S.sname============");					
		    session=sf.openSession();
		    query=session.createQuery(hql);
		    Iterator i=query.iterate();
		    while(i.hasNext())
		    {
		    	Object row[]=(Object [])i.next();
		    	System.out.println("Count="+row[0]+"    Course="+row[1]);
		    	
		    }
		    
		    
		    
		    
		    
		    // Named Parameters in HQL Example
		     hql = "FROM Student S WHERE S.sname = :name";
		     query = session.createQuery(hql);
		    query.setParameter("name","Prakash");
		    List result = query.list();
		    Iterator it3=result.iterator();
		    System.out.println(" ========== Output for HQL  Query Parameter Demo  : FROM Student S WHERE S.sname = :name============");					
		    while(it3.hasNext())
		    {

		    	Student student=(Student)it3.next();
		    	System.out.print(" Roll="+student.getSroll());
		    	System.out.print(" Name="+student.getSname());
		    	System.out.println(" Course="+student.getScourse());
		    	
		    }
		    
		    
		    
		    
		    //Pagination  Example with HQL
		     hql = "FROM Student";
		     query = session.createQuery(hql);
		    query.setFirstResult(1);
		    query.setMaxResults(4);
		    List resultList = query.list();
		    Iterator it4=resultList.iterator();
		    System.out.println(" ========== Output for HQL  Query with pagination ===========");					
		    while(it4.hasNext())
		    {

		    	Student student=(Student)it4.next();
		    	System.out.print(" Roll="+student.getSroll());
		    	System.out.print(" Name="+student.getSname());
		    	System.out.println(" Course="+student.getScourse());
		    	
		    }
		    
		    
		    		   

		    
		    
		    
		    
		    
		    
			   session.close();
			   
			   
		   
		   
	    
	    

				
									
	}
	
}
