package com.igate.pl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.igate.entity.*;
import com.igate.util.HibernateUtil;



 // One To One Hibernate Association Mapping Demo
// A Student can have only one permanent Address 
 
public class Main {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Address address1 = new Address("Maggarpatta", "Pune", "MH", "600097");
			Address address2 = new Address("MG Road", "Banglore", "Karnataka", "560000");
			Student student1 = new Student("Karthik", address1);
			Student student2 = new Student("Mohan", address2);
			session.save(student1);
			session.save(student2);
			transaction.commit();
			System.out.println(" ========Students Created==========");
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}
