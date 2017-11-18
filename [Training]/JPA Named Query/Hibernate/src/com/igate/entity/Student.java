/**
 * 
 */
package com.igate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@NamedQueries(
		{
			@NamedQuery(name="FindAllStudents",query="SELECT s FROM Student s"),
			@NamedQuery(name="FindAllStudentsByName",query="SELECT s FROM Student s WHERE s.sname=:name"),
			@NamedQuery(name="FindAllStudentsByCourse",query="SELECT s FROM Student s WHERE s.scourse=:course")
			
		})
             
public class Student 
{
	
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
	
}
