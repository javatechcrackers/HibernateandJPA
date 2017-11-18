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
    	
    	
    	
    	

    	
    	
    	
    	//Query
    	/*
    	List joinList = session.createQuery("from Student as s inner join s.courses").list();
    	
    	Iterator ite = joinList.iterator();
    	while(ite.hasNext())
    	{
    	Object [] objects = (Object []) ite.next();
    	Student student = (Student)objects[0];
    	Course course = (Course)objects[1];
    	System.out.print("Student Name " + student.getStudentName());
    	System.out.println("   Course Name "+ course.getCourseName());
    	}

    	*/
    	
    	
    	/*
    	List aggreList = session.createQuery("select count(distinct s.studentName) from Student as s inner join s.courses").list();
    	System.out.println("Total Number of Students "+ aggreList.toString());
		*/
    	
    	
    	
    	/* Order By demo
    	      	 
    	List orderList = session.createQuery("select s from Student s order by s.studentName asc").list();
    	for(Object ol : orderList)
    	System.out.println("Student name in ascending order "+ ((Student)ol).getStudentName());

    	*/

    	
    	
    	/*   HQL Group By example
    	 * 
    	 * List groupList = session.createQuery("select c.courseName, count(distinct c.courseName) from Student as s, Course c inner join s.courses group by c.courseName").list(); //A query that returns aggregate values can be grouped by any property of a returned class or components
	ite = groupList.iterator();
	while(ite.hasNext()){
	Object [] objects = (Object []) ite.next();
	System.out.println("Course Name is "+ objects[0]);
	System.out.println("Count representation of the above course "+ objects[1]);


    	 * 
    	 * 
    	 */
    	
    	
    	
    	
    	//HQL sub query demo
    	/*
    	 * HQL Subqueries:

Hibernate supports subqueries within queries for the databases that allows subselects.A subquery must be surrounded by parentheses.

List subList = session.createQuery("select s from Student s where s.studentName not in (select distinct s from Student as s inner join s.courses where s.studentName= 'Sekar')").list();
System.out.println("List size "+ subList.size());
for(Object sl: subList)
System.out.println("Student Name from the sub query is "+ ((Student)sl).getStudentName());

*/
    	
    	 
    	
    
  /* Hibernate Native SQL Queries
   * 
   * 
   *   Native SQL Queries:

Hibernate also supports native SQL queries. We can directly use the native SQL queries in the place of HQL queries with one minor change. The method session.createSQLQuery() should be used instead of session.createQuery() as follows.

List nativeSqlList = session.createSQLQuery("select * from STUDENTS").list(); // STEDENTS refer the actual table name
ite = nativeSqlList.iterator();
while(ite.hasNext()){
Object [] objects = (Object []) ite.next();
System.out.println("Student Id "+ objects[0]);
System.out.println("Student name "+ objects[1]);
	
   */
    	
    	
    	/*

    	
    	String courseHQL = "from Course where courseName='java' ";
    	Query courseQuery = session.createQuery(courseHQL);
    	Course course = (Course) courseQuery.list().get(0);
    	String hql = "from Student as student where student.courses=:course";
    	Query query = session.createQuery(hql);
    	query.setEntity("course",course);
    	List results = query.list();
    	Iterator ite = results.iterator();
    	while(ite.hasNext())
    	{
    	
    		Student st=(Student)ite.next();
    		System.out.println(st.getStudentName());
    		    		
    	}
    	*/
    	
    	
    }
}