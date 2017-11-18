package com.igate.pl;

import java.util.HashSet;

import java.util.Set;
import com.igate.entity.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.igate.util.HibernateUtil;

// One to Many Association Demo. 
// Multiple Phone numbers can be asigned to a single student

public class Main {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			
			Set<Phone> phoneNumbers = new HashSet<Phone>();
			phoneNumbers.add(new Phone("Office","998887733"));
			phoneNumbers.add(new Phone("Home","9889343423"));
			
			Student student = new Student("Vinod", phoneNumbers);
			session.save(student);			
			transaction.commit();
			System.out.println(" =========Student with phone numbers Inserted=======");
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}
