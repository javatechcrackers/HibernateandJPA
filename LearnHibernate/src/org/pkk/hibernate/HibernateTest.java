package org.pkk.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.pkk.dto.Address;
import org.pkk.dto.UserDetails;
import org.pkk.dto.UserDetails2;
import org.pkk.dto.UserDetails2;

public class HibernateTest {

	public static void main(String[] args) {
		
		UserDetails user = new UserDetails();
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
		
		user.setHomeaddress(addr);
		user.setOfficeaddress(addr2);
		user.setJoinedDate(new Date());
		user.setDiscription("inautix");
		
		UserDetails user2 = new UserDetails();
		//user.setUserId(2);
		user2.setName("PKKG");
		//user2.setAddress("Pune");
		user2.setJoinedDate(new Date());
		user2.setDiscription("inautix");
		
		 @SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		 Session session = sessionFactory.openSession();
		 session.beginTransaction();
		 
		 session.save(user);
		 session.save(user2);
		 session.getTransaction().commit();
		 session.close();
		 
		 user = null;
		 session = sessionFactory.openSession();
		 session.beginTransaction();
		 
		 user = (UserDetails)session.get(UserDetails.class, 2);
		 System.out.println(user.getName());

	}

}
