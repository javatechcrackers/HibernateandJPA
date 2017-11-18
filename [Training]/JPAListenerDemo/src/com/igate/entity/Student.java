package com.igate.entity;
/**
 * 
 */


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.Table;

import com.igate.listeners.StudentListener;
import com.igate.listeners.StudentValidateListener;

/**
 * @author Administrator
 *
 */
@Entity
@Table(name="student56")

@EntityListeners({StudentListener.class,StudentValidateListener.class})

public class Student {
	
	@Id
	@GeneratedValue
	private int id;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="sname", length=100,nullable=false)
	private String sname;

	/**
	 * @return the sname
	 */
	public String getSname() {
		return sname;
	}

	/**
	 * @param sname the sname to set
	 */
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	@Column(name="sroll",nullable=false)
	private int sroll;

	/**
	 * @return the sroll
	 */
	public int getSroll() {
		return sroll;
	}

	/**
	 * @param sroll the sroll to set
	 */
	public void setSroll(int sroll) {
		this.sroll = sroll;
	}
	
	@Column(name="scourse",length=10,nullable=false)
	private String scourse;

	/**
	 * @return the scourse
	 */
	public String getScourse() {
		return scourse;
	}

	/**
	 * @param scourse the scourse to set
	 */
	public void setScourse(String scourse) {
		this.scourse = scourse;
	}
	
   @PostPersist
   @PostUpdate
   @PostLoad
   private void resetSyncTime()
   {
	  long syncTime=System.currentTimeMillis();
	  System.out.println("Student.resetSyncTime called on studentId:"+getId());
	  
   }
	
	
}
