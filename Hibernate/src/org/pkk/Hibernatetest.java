package org.pkk;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.pkk.DTO.*;

public class Hibernatetest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDetails user = new UserDetails();
		user.setUserID(1);
		user.setUserName("Prashant");
		
		
		//("hibernate.cfg.xml")
		
		SessionFactory factory = new  Configuration().configure().buildSessionFactory();	
		Session session = factory.openSession();
		session.beginTransaction();
		
		session.save(user);
		session.getTransaction().commit();
	}

}
