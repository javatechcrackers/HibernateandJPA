package org.pkk.dto;



import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="USER_DETAILS")
public class UserDetails {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private int userId;
	
	@Column(name="USER_NAME")
	private String name;
	
	@Embedded //@Embedded 
	@AttributeOverrides({
	@AttributeOverride(column = @Column(name="HOME_STREET") , name = "street"),
	@AttributeOverride(column = @Column(name="HOME_CITY") , name = "city"),
	@AttributeOverride(column = @Column(name="HOME_STATE") , name = "state"),
	@AttributeOverride(column = @Column(name="HOME_COUNTRY") , name = "country")
	
	})
	private Address homeaddress;
	
	@Embedded //@Embedded 
	private Address officeaddress;
	
	
	//@Transient
	//this annotation skip this field & wont create any field in DB
	@Temporal(TemporalType.DATE) //it will save only date not full timestamp
	private Date joinedDate;
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	
	public Address getHomeaddress() {
		return homeaddress;
	}
	public void setHomeaddress(Address homeaddress) {
		this.homeaddress = homeaddress;
	}
	public Address getOfficeaddress() {
		return officeaddress;
	}
	public void setOfficeaddress(Address officeaddress) {
		this.officeaddress = officeaddress;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	
	@Lob
	private String discription;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	/*
	 * there are two way to place annotation
	 * 1. on top of getter 
	 * 2. on top of variable declaration
	 * 
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
