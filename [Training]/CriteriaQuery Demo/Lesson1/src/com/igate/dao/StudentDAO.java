package com.igate.dao;

import java.util.*;
import java.sql.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import com.igate.util.*;
import com.igate.entity.Student;


public class StudentDAO
{
    
	 Session session = HibernateUtil.getSessionFactory().openSession(); 
	 
	 
	  //Build a simple criteria with no restriction
	  public void simpleCriteriaWithNoRestriction()
	   {                             
        System.out.println("\n---Using criteria with no restriction...");
        Criteria crit = session.createCriteria(Student.class);
        List results = crit.list();
        displayStudentsList(results);
	   }
	  
       
	  
       //example of Restriction and Projection
	   public  void criteriaWithRestrictionAndProjection()
	    {	    	        
          System.out.println("\n---Using criteria with restriction and projection...");
          Criteria crit = session.createCriteria(Student.class);
          crit.add(Restrictions.gt("studentMarks",new Double(95)));
          crit.setProjection(Projections.property("studentName"));
          List results = crit.list();
          Iterator iterator=results.iterator();
          while(iterator.hasNext())
          {
            	System.out.println(iterator.next());
          }
          
        }
    
    
    
    
       //Example on  Multiple projections
	   public void criteriaWithMultipleProjections()
	    {	    		
		   System.out.println(" ====== Criteria with multiple projections =======");
		   
        Criteria crit = session.createCriteria(Student.class);
    	ProjectionList projList = Projections.projectionList();
    	projList.add(Projections.property("studentName"));
    	projList.add(Projections.property("studentMarks"));
    	//projList.add(Projections.avg("studentMarks"));
    	//projList.add(Projections.countDistinct("studentName"));
    	crit.setProjection(projList);
    	List results = crit.list();
    	Iterator iter=results.iterator();
    	while (iter.hasNext()){
            Object i[]= (Object[])iter.next();
            for(int y=0;y<i.length;y++)
            System.out.println(i[y]);
    	}
    	
	    }
	    
    	
    	    	
    	
        //Example of grouping result set with projections
	   
	    public void criteriaWithGroupingResultsetWithProjections()
	    {
	    System.out.println("======= Grouping ResultSet with Projections ==========");
	    	
        Criteria crit = session.createCriteria(Student.class);
    	ProjectionList projList = Projections.projectionList();    	
    	
    	projList.add(Projections.rowCount() );
    	projList.add(Projections.groupProperty("studentName"));
        projList.add( Projections.avg("studentMarks") );
        projList.add( Projections.max("studentMarks"));
    	projList.add(Projections.countDistinct("studentName"));
    	
    	
    	crit.setProjection(projList);
    	List results = crit.list();
    	Iterator iter=results.iterator();
    	while (iter.hasNext()){
    		
            Object i[]= (Object[])iter.next();
            for(int y=0;y<i.length;y++)
            {
            System.out.print(i[y]+"\t");
            }
            System.out.println();
    	}
        
    	
	    }
	    
    	
    	
        
       // Build a simple criteria with paging
	   public void simpleCriteriaWithPaging()
	    {
            System.out.println("\n========Using criteria with paging========");
            Criteria crit = session.createCriteria(Student.class);
            crit.setFirstResult(1);   // Starting row
            crit.setMaxResults(2);    // Size of each page
            List results = crit.list();
            displayStudentsList(results);
        }

	   
       // Build a criteria with two conditions
	   public void criteriaWithTwoConditions()
	    {        
            System.out.println("\n---Using criteria with two Restrictions...");
            Criteria crit = session.createCriteria(Student.class);
            crit.add(Restrictions.gt("studentMarks",new Double(40)));
            crit.add(Restrictions.like("studentName","K%"));
            
            List results = crit.list();
            displayStudentsList(results);
        }
        

	   
        // Build a criteria with a Restriction.like
        public void criteriaWithRestrictionLike()
        {
            System.out.println("\n---Using criteria with Restriction.like...");
            Criteria crit = session.createCriteria(Student.class);
            crit.add(Restrictions.ilike("studentName","K%"));            
            List results = crit.list();
            displayStudentsList(results);
        }
        
    	
        // Build a criteria with Restrictions.or
        public void criteriaWithRestrictionOr()
        {
            System.out.println("\n---Using criteria with Restrictions.or... ");
            Criteria crit = session.createCriteria(Student.class);
            Criterion marks = Restrictions.gt("studentMarks",new Double(95.0));
            Criterion name = Restrictions.ilike("studentName","K%");
            LogicalExpression orExp = Restrictions.or(marks,name);
            crit.add(orExp);            
            List results = crit.list();
            displayStudentsList(results);
        }
        
    	
    	
        // Build a criteria with Criteria.DISTINCT_ROOT_ENTITY
         public void criteriaWithDISTINCT_ROOT_ENTITY()
         {
        	 System.out.println(" ==== Criteria with Distinct root entities========");
            System.out.println("\n---Using criteria with Criteria.DISTINCT_ROOT_ENTITY... ");
            Criteria crit = session.createCriteria(Student.class);
            crit.add(Restrictions.gt("studentMarks",new Double(40)));
            crit.add(Restrictions.like("studentName","K%"));
            crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            List results = crit.list();
            displayStudentsList(results);
        }
        
    	
        // Build a criteria with Order
         public void criteriaWithOrder()
        {
            System.out.println("\n------Using criteria with Order======= ");
            Criteria crit = session.createCriteria(Student.class);
            crit.add(Restrictions.gt("studentMarks",new Double(40)));
            crit.addOrder(Order.asc("studentName"));
            
            List results = crit.list();
            displayStudentsList(results);
            
        }
        
        
    
         // Below are utility methods    
         public  void displayStudentsList(List list)
         {
        	 Iterator iter = list.iterator();
        	 if (!iter.hasNext()){
        		 System.out.println("No students to display.");
        		 return;
        	 }
        	 while (iter.hasNext()){
        		 Student student = (Student) iter.next();
        		 String msg = student.getStudentId() + "\t";
        		 msg += student.getStudentName() + "\t";
        		 msg += student.getStudentMarks() ;
        		 System.out.println(msg);
        	 }
         }
    
   
    
         public void prepareTestData()
         {
        	 Session session = HibernateUtil.getSessionFactory().openSession();
        	 Transaction tx = session.beginTransaction();
        	 
        	 Student student1=new Student();
        	 student1.setStudentId(1);
        	 student1.setStudentName("Pramod");
        	 student1.setStudentMarks(99.4);
        	 session.save(student1);
        
        	 Student student2=new Student();
        	 student2.setStudentId(2);
        	 student2.setStudentName("Sachin");
        	 student2.setStudentMarks(97.5);
        	 session.save(student2);
        
        
        	 Student student3=new Student();
        	 student3.setStudentId(3);
        	 student3.setStudentName("Mandar");
        	 student3.setStudentMarks(93.6);
        	 session.save(student3);
        
        
        	 Student student4=new Student();
        	 student4.setStudentId(4);
        	 student4.setStudentName("Rashmi");
        	 student4.setStudentMarks(92.8);
        	 session.save(student4);
        
        
        	 Student student5=new Student();
        	 student5.setStudentId(5);
        	 student5.setStudentName("Karthik");
        	 student5.setStudentMarks(89.4);
        	 session.save(student5);
                        
        	 Student student6=new Student();
        	 student6.setStudentId(6);
        	 student6.setStudentName("Karthik");
        	 student6.setStudentMarks(45.4);
        	 session.save(student6);
        	 
	  
     
        	 tx.commit();
        	 session.close();
        	 
        }
}