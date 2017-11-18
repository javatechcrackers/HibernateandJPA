package com.igate.pl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.igate.entity.*;
import com.igate.util.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Address address = new Address("M.G. Road", "Bangalore", "TN", "600097");
			Student student = new Student("Saroj", address);
			session.save(student);
			transaction.commit();
			System.out.println(" ========Students inserted========");
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}
