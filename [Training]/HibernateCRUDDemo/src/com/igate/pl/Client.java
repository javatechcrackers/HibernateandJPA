package com.igate.pl;

import java.util.Scanner;

import com.igate.bo.StudentBO;
import com.igate.entity.Student;

/*
 * Class Name : Client.java
 * 
 * Description : The main client for the CRUD application , a menu driven Client demo.
 On Running the Client app it shows the following menu to choose option 
 for performing specific CRUD operation and asking the user to input the required values

 Choose an operation to be perfomed from the below list:
 1. Add Student
 2. Search Student
 3. Update Student
 4. Delete Student
 5. Exit
 */

public class Client {

	public static void main(String[] ar) {
		int choice = 0;
		Scanner scanner = new Scanner(System.in);
		String check = "n";
		StudentBO studentBO = new StudentBO();
		int studentId = 0;
		Student student = null;
		String studentName = "";
		String result = "";
		do {

			System.out
					.println("Choose an operation to be perfomed from the below list");
			System.out
					.println(" 1. Add Student\n 2. Search Student\n 3. Update Student\n 4. Delete Student\n 5. Exit\n");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the student name and student marks:");
				studentName = scanner.next();
				double studentMarks = Double.parseDouble(scanner.next());

				student = new Student();

				student.setStudentName(studentName);

				student.setStudentMarks(studentMarks);
				studentId = studentBO.addStudent(student);
				if (studentId > 0)
					System.out
							.println("Student Added successfully and the student id is: "
									+ studentId);
				else
					System.out.println("Adding student failed");
				break;
			case 2:
				System.out
						.println("Enter the id of the student to be searched");
				studentId = scanner.nextInt();
				student = studentBO.searchStudent(studentId);
				if (student != null) {
					System.out.println("Student Name: "
							+ student.getStudentName());
					System.out.println("Student Marks: "
							+ student.getStudentMarks());
				} else {
					System.out.println("Searched student not available");
				}
				break;
			case 3:
				System.out.println("Enter the student Id to update");
				studentId = scanner.nextInt();
				System.out.println("Enter the new student name");
				studentName = scanner.next();
				result = studentBO.updateStudent(studentId, studentName);
				System.out.println(result);
				break;
			case 4:
				System.out.println("Enter the student Id to deleted");
				studentId = scanner.nextInt();
				result = studentBO.removeStudent(studentId);
				System.out.println(result);
				break;
			case 5:
				System.exit(0);
				break;
			default:
				System.out.println("Enter a valid option");
				break;
			}
			System.out.println("Would you like to continue y/n");
			check = scanner.next();
		} while (check.equalsIgnoreCase("y"));

	}

}
