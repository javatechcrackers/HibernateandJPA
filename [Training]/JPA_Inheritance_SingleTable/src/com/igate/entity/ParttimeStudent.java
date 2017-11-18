package com.igate.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT")
@DiscriminatorValue("PART")
public class ParttimeStudent extends Student
{
	@Column(name="HOURS")
	private int hours;
	public int getHours()
	{
		return hours;
	}
	public void setHours(int hours) 
	{
		this.hours = hours;     
	}
} 
