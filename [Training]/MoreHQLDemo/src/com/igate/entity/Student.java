package com.igate.entity;
import java.util.*;

public class Student 
{

	private long id;

	private String studentName;

	/* 
	 * 
	 *Note that only Student entity has the references to Course entity and the later entity does not have any reference to the former entity. Hence only a unidirectional navigation is possible. 
	 * 
	 */
	
	private Set courses = new HashSet();
	public Student()
	{
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Set getCourses() {
		return courses;
	}

	public void setCourses(Set courses) {
		this.courses = courses;
	}

	
	
}