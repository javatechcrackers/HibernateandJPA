package com.igate.pl;

import java.util.HashSet;
import java.util.Set;

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

			Set<Course> courses = new HashSet<Course>();
			courses.add(new Course("English"));
			courses.add(new Course("Computer Science"));

			Student student1 = new Student("Vinod", courses);
			Student student2 = new Student("Pramod", courses);
			session.save(student1);
			session.save(student2);

			transaction.commit();
			System.out.println(" ========Students inserted=========");
			
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}
}
