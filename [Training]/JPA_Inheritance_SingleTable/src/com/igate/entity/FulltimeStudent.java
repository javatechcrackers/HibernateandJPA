package com.igate.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT")
@DiscriminatorValue("FULL")
public class FulltimeStudent extends Student
{
	@Column(name="YEARS")
	private int years;
	
	public int getYears()
	{
		return years;
	}
	public void setYears(int years)
	{
		this.years = years;
	}
} 
