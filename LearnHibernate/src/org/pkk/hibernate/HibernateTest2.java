package org.pkk.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.pkk.dto.Address;
import org.pkk.dto.UserDetails2;


public class HibernateTest2 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		UserDetails2 user = new UserDetails2();
		//user.setUserId(2);
		user.setName("PKK");
		Address addr = new Address();
		addr.setStreet("Makrand Nagar");
		addr.setCity("Kannuj");
		addr.setState("Uttar Pradesh");
		addr.setCountry("India");
		
		Address addr2 = new Address();
		addr2.setStreet("Magarpatta");
		addr2.setCity("Hadapsar");
		addr2.setState("MH");
		addr2.setCountry("India");
		
		user.getListofAddress().add(addr);
		user.getListofAddress().add(addr2);
		
		
		
		
		 SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		 Session session = sessionFactory.openSession();
		 session.beginTransaction();
		 
		 session.save(user);
		
		 session.getTransaction().commit();
		 session.close();
		 
		 user = null;
		 session = sessionFactory.openSession();
		 session.beginTransaction();
		 
		 /*user = (UserDetails2)session.get(UserDetails2.class, 2);
		 System.out.println(user.getName());*/

	}

}
