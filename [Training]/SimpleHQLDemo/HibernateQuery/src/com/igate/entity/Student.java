/**
 * 
 */
package com.igate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


public class Student 
{

	private long id;
	private String sname;
	private int sroll;
	private String scourse;
					

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getSname() {
		return sname;
	}

	
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	
	

	public int getSroll() {
		return sroll;
	}

	
	public void setSroll(int sroll) {
		this.sroll = sroll;
	}
	
	
	

	
	public String getScourse() {
		return scourse;
	}

	
	public void setScourse(String scourse) {
		this.scourse = scourse;
	}
	
}
