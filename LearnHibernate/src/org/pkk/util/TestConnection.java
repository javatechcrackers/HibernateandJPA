package org.pkk.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection {
	private static final String DEFAULT_DRIVER = "org.postgresql.Driver";
    private static final String DEFAULT_URL = "jdbc:postgresql://localhost:5432/hibernatedb";
    private static final String DEFAULT_USERNAME = "postgres";
    private static final String DEFAULT_PASSWORD = "1234";
    
   
    static Connection connection = null;
    static Statement stmt = null;
    
	public static void main(String[] args) throws ClassNotFoundException {
		
		 Class.forName(DEFAULT_DRIVER);
	    
		// create();
		// insert();
		 fetch();
		 
		
			
			
			
			 
		} 
	

	private static void fetch() {
		try {

			connection = DriverManager.getConnection(DEFAULT_URL,DEFAULT_USERNAME,DEFAULT_PASSWORD);
			
			stmt = connection.createStatement();
	         ResultSet rs = stmt.executeQuery( "SELECT * FROM COMPANY;" );
	         while ( rs.next() ) {
	            int id = rs.getInt("id");
	            String  name = rs.getString("name");
	            int age  = rs.getInt("age");
	            String  address = rs.getString("address");
	            float salary = rs.getFloat("salary");
	            System.out.println( "ID = " + id );
	            System.out.println( "NAME = " + name );
	            System.out.println( "AGE = " + age );
	            System.out.println( "ADDRESS = " + address );
	            System.out.println( "SALARY = " + salary );
	            System.out.println();
	         }
	         rs.close();
	         stmt.close();
	         connection.close();
		
	}catch (SQLException e) {

		System.out.println("Connection Failed! Check output console");
		e.printStackTrace();
		return;

	}	
	if (connection != null) {
		System.out.println("You made it, take control your database now!");
	} else {
		System.out.println("Failed to make connection!");
	}
		
	}

	private static void insert() {
		try {

			connection = DriverManager.getConnection(DEFAULT_URL,DEFAULT_USERNAME,DEFAULT_PASSWORD);
			
			stmt = connection.createStatement();
	         String sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
	               + "VALUES (1, 'Paul', 32, 'California', 20000.00 );";
	         stmt.executeUpdate(sql);

	         sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
	               + "VALUES (2, 'Allen', 25, 'Texas', 15000.00 );";
	         stmt.executeUpdate(sql);

	         sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
	               + "VALUES (3, 'Teddy', 23, 'Norway', 20000.00 );";
	         stmt.executeUpdate(sql);

	         sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
	               + "VALUES (4, 'Mark', 25, 'Rich-Mond ', 65000.00 );";
	         stmt.executeUpdate(sql);
		
	}catch (SQLException e) {

		System.out.println("Connection Failed! Check output console");
		e.printStackTrace();
		return;

	}	
	if (connection != null) {
		System.out.println("You made it, take control your database now!");
	} else {
		System.out.println("Failed to make connection!");
	}
		
	}

	private static void create() {
		try {

			connection = DriverManager.getConnection(DEFAULT_URL,DEFAULT_USERNAME,DEFAULT_PASSWORD);
			
			stmt = connection.createStatement();
			  String sql = "CREATE TABLE COMPANY " +
                      "(ID INT PRIMARY KEY     NOT NULL," +
                      " NAME           TEXT    NOT NULL, " +
                      " AGE            TEXT     NOT NULL, " +
                      " ADDRESS        CHAR(50), " +
                      " SALARY         REAL)";
			  
			  String person = "CREATE TABLE PERSON " +
                      "(ID INT PRIMARY KEY     NOT NULL," +
                      " FIRST_NAME           TEXT    NOT NULL, " +
                      " LAST_NAME            TEXT     NOT NULL) ";
			  
         stmt.executeUpdate(person);
         stmt.close();
         connection.close();
		
	}catch (SQLException e) {

		System.out.println("Connection Failed! Check output console");
		e.printStackTrace();
		return;

	}	
	if (connection != null) {
		System.out.println("You made it, take control your database now!");
	} else {
		System.out.println("Failed to make connection!");
	}
	}
}
