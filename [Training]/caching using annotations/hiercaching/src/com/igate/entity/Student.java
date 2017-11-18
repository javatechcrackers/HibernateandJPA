package com.igate.entity;
import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;



@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Student {

	private long studentId;
	private String studentName;
	

	public Student() {
	}

	

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name = "STUDENT_ID")
	public long getStudentId() {
		return this.studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	@Column(name = "STUDENT_NAME", nullable = false, length = 100)
	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	

}