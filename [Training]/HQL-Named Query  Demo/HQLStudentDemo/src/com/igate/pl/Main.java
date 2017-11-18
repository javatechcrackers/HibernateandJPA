package com.igate.pl;
import java.util.*;

import java.sql.*;
import org.hibernate.*;
import org.hibernate.criterion.*;

import com.igate.entity.Course;
import com.igate.entity.Student;
import com.igate.util.*;

public class Main 
{
    
    public static void main(String[] args) 
    {
    	Session session=HibernateUtil.getSessionFactory().openSession();
    	
    	Transaction t=session.beginTransaction();
    	
    	
    	Course c1=new Course();
    	c1.setCourseName("java");
    	Course c2=new Course();
    	c2.setCourseName("Dotnet");
    	Course c3=new Course();
    	c3.setCourseName("C lang");
    	Course c4=new Course();
    	c4.setCourseName("VC++");
    	
    	
    	Student s=new Student();
    	s.setStudentName("Sarba");
    	
    	Set set=new HashSet();
    	set.add(c1);
    	set.add(c2);
    	s.setCourses(set);
    	session.save(s);
    	
    	System.out.println(" student1 created");
    	
    	Student s2=new Student();
    	s2.setStudentName("Hruda");
    	
    	Set set2=new HashSet();
    	set2.add(c2);
    	set2.add(c3);
    	set2.add(c4);
    	
    	s2.setCourses(set2);
    	
    	session.save(s2);
    	System.out.println(" student2 created");
    	    	    	    	    	    	        	
    	t.commit();
    	    	    	    	    	    	    	
    	// Named Query Demo
    	List studentList = session.getNamedQuery("findStudentsByName").setString("sname", "Sarba").list();
    	for(Object obj: studentList)
    	System.out.println("Student Id is "+ ((Student)obj).getId());
    	    	    	
    	List nativeSqlList = session.getNamedQuery("namedNativeStudentSQL").list();
    	Iterator ite = nativeSqlList.iterator();
    	
    	while(ite.hasNext()){
    	Object [] objects = (Object []) ite.next();
    	System.out.println("Student Id "+ objects[0]);
    	System.out.println("Student name "+ objects[1]);
    	}

    	
    }
}