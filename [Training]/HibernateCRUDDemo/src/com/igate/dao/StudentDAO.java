package com.igate.dao;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.igate.entity.Student;
import com.igate.util.HibernateUtil;

/*
 * Class Name : StudentDAO
 * 
 * Description : Implements DAO Layer methods to perform various CRUD operations. 
 *             
 *           
 */

public class StudentDAO {
	Session session = null;
	Transaction transaction = null;

	/*
	 * Method Name : addStudent Description : persists a new student entity into
	 * the database Params : Student student return : studentId if persisted
	 * successfully , 0 if fails to persist
	 */

	public int addStudent(Student student) {
		int studentId = 0;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// save method persists the category object as one record in the
			// table
			studentId = (Integer) session.save(student);
			transaction.commit();

		} catch (HibernateException hibernateException) {
			if (transaction != null) {
				transaction.rollback();
				studentId = 0;
			}
		}
		return studentId;
	}

	/*
	 * Method Name : searchStudent Description : Finds an existing student from
	 * the Database. Params : int studentId return : The student instance if
	 * successfully finds an instance or else returns null
	 */

	public Student searchStudent(int studentId) {
		Student student = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// load or get method can be used to find the records or objects.
			// Difference between both
			// can be find in slide 19 of lesson 2

			student = (Student) session.get(Student.class, new Integer(
					studentId));
			transaction.commit();

		} catch (HibernateException hibernateException) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return student;
	}

	/*
	 * Method Name : updateStudent Description : Updates a student entity with
	 * given studentId to a new studentName value.
	 * 
	 * Param : int studentId (id of the Student entity which is updated) param :
	 * String studentName (New name of the student entity to be updated )
	 * 
	 * 
	 * return : String ( On successful updation returns
	 * "student updated successfully", returns "Updation failed " On failure in
	 * updation .)
	 */

	public String updateStudent(int studentId, String studentName) {
		Student student = null;
		String result = "";
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			student = (Student) session.get(Student.class, new Integer(
					studentId));
			if (student != null) {
				student.setStudentName(studentName);
				session.saveOrUpdate(student);
				transaction.commit();
				result = "Student updated successfully";
			}

		}

		catch (HibernateException hibernateException) {
			if (transaction != null) {
				transaction.rollback();
				result = "Updation failed";
			}
		}

		return result;
	}

	/*
	 * Method Name : removeStudent Description : Deletes a Student record with
	 * the given studentId from Database
	 * 
	 * Params : int studentId (studentId of the Student entity to be deleted )
	 * return : String ( On successful deletion returns
	 * "student removed successfully", returns "Error while removing student "
	 * On failure .)
	 */

	public String removeStudent(int categoryId) {
		String result = "";
		Student student = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			student = (Student) session.get(Student.class, categoryId);
			if (student != null) {
				session.delete(student);
				transaction.commit();
				result = "Student removed successfully";
			}
		} catch (HibernateException hibernateException) {
			if (transaction != null) {
				transaction.rollback();
				result = "Error while removing the Student";
			}
		}
		return result;
	}
}
