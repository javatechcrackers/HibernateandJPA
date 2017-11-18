package com.igate.listeners;

import javax.persistence.PostPersist;
import javax.persistence.PreRemove;


import com.igate.entity.Student;

public class StudentListener 
{
	  @PreRemove
	  public void preRemove(Student student)
	  {
	    System.out.println("preRemove() of StudentListener called on student id: " + student.getId());
	  }
	  
	  @PostPersist
	  public void studentCreation(Student student)
	  {
		 System.out.println(" Student created "+student);
	  }

	}