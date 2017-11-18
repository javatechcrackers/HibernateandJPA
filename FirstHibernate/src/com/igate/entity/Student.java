package com.igate.entity;

import javax.persistence.Entity;



/*
 * Class Name : Student.java 
 * Description : Entity class which instance needs to be persisted
 *               by the application contains private members ,
 *               Constructors and  public getter and setters.
 * 
 */
@Entity

public class Student {
	
	private int studentId;
	private String studentName;
	private double studentMarks;
	
	public Student()
	{
				
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public double getStudentMarks() {
		return studentMarks;
	}

	public void setStudentMarks(double studentMarks) {
		this.studentMarks = studentMarks;
	}

	

}
