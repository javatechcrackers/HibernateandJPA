package com.igate.listeners;

import javax.persistence.PrePersist;

import com.igate.entity.Student;

public class StudentValidateListener
{
	
	  @PrePersist
	  public void validate(Student student) 
	  {
	    System.out.println("prePersist of  StudentValidateListener is called." );
	  }
}
