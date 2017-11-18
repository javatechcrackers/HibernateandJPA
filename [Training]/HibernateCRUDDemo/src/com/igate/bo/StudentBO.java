package com.igate.bo;

import com.igate.dao.StudentDAO;
import com.igate.entity.Student;

/*
 * Class Name : StudentBO
 * 
 * Description : Defines various business methods which accepts client data and
 *               calls necessory dao methods for performing CRUD operations
 *           
 */

public class StudentBO {

	StudentDAO studentDAO = null;

	/*
	 * Method Name : addStudent Description : persists a new student entity into
	 * the database Params : Student student return : studentId if persisted
	 * successfully , 0 if fails to persist
	 */

	public int addStudent(Student student) {
		// Validation to be done for the category details

		studentDAO = new StudentDAO();
		int studentId = studentDAO.addStudent(student);
		return studentId;

	}

	/*
	 * Method Name : searchStudent Description : Finds an existing student from
	 * the Database. Params : int studentId return : The student instance if
	 * successfully finds an instance or else returns null
	 */

	public Student searchStudent(int studentId) {
		studentDAO = new StudentDAO();
		Student student = studentDAO.searchStudent(studentId);
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
		studentDAO = new StudentDAO();
		String result = studentDAO.updateStudent(studentId, studentName);
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

	public String removeStudent(int studentId) {
		studentDAO = new StudentDAO();
		String result = studentDAO.removeStudent(studentId);
		return result;
	}

}
