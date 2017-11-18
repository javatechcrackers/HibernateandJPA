package com.igate.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="PARTTIME_STUDENT")
@AttributeOverrides({
    @AttributeOverride(name="firstname", column=@Column(name="FIRSTNAME")),
    @AttributeOverride(name="lastname", column=@Column(name="LASTNAME"))
})
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
