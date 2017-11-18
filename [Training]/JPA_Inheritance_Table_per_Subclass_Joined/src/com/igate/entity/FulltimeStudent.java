package com.igate.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="FULLTIME_STUDENT")
@PrimaryKeyJoinColumn(name="STUDENT_ID")
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
