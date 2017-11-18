package com.igate.pl;

import java.io.Serializable;
import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.criterion.*;
import org.hibernate.event.*;
import org.hibernate.event.def.*;

import com.igate.entity.*;
import com.igate.util.HibernateUtil;

public class Main {
   public static void main(String[] args) throws Exception 
   {
     
      SessionFactory fec=HibernateUtil.getSessionFactory();
	  Session session = fec.openSession();		     

      Transaction transaction = null;

      try {
    	  transaction = session.beginTransaction();
    	  
    	   Group team1 = new Group("team1");
                    
           
           Student s = new Student("Maneesh");
           Student s1 = new Student("Vinod");
           
           s.setParent(team1);
           s1.setParent(team1);
           
           
           HashSet set = new HashSet();
           set.add(s);
           set.add(s1);
           
           team1.setStudents(set);
           session.saveOrUpdate(team1);
           System.out.println(" =========== Team 1 Saved ==========");
           
           Group team2 = new Group("team2");
           HashSet set2 = new HashSet();
           Student s2 = new Student("Arjun");
           Student s3 = new Student("Govind");
           
           s2.setParent(team2);
           s3.setParent(team2);
           
           set2.add(s2);
           set2.add(s3);
           
           team2.setStudents(set2);
          session.saveOrUpdate(team2);
          System.out.println(" =========== Team 2 Saved ==========");
          
       
					
           
           transaction.commit();
      } catch (Exception e) { 
           if (transaction != null) {
             transaction.rollback();
             throw e;
           }
      }  finally { 
           session.close();
      }
      
      
      
      
          
   }
}
