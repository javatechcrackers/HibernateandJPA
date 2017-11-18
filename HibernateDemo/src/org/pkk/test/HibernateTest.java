package org.pkk.test;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.omg.CORBA.portable.ApplicationException;
import org.pkk.dto.UserDetails;

public class HibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		UserDetails user = new UserDetails();
		
		try{
		user.setUserId(105);
		//user.setUserId(104);
		user.setUserName("prashant");
	//	user.setUserName("ravi");
		
		SessionFactory sessionFactory= new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		}
		catch(HibernateException e){
		System.out.println("Exception in try :: " + e);
	}}

} 
