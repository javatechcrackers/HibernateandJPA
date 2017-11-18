package com.igate.entity;

public class Student
{    
    private int studentId;
    private String studentName;
    private double studentMarks;
    public Student() 
    {
    	
    }

    public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public double getStudentMarks() {
		return studentMarks;
	}

	public void setStudentMarks(double studentMarks) {
		this.studentMarks = studentMarks;
	}

	@Override
    public String toString() 
    {
        return "Student Id:="+studentId+" Student Name:="+studentName+" Student Marks:="+studentMarks;
    }
}//End of Employee.java

