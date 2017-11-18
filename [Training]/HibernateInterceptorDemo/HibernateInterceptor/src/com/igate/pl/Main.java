package com.igate.pl;
import com.igate.dao.*;


public class Main 
{
    
    public static void main(String[] args) 
    {
    	// Invoking dao method from main directly
    	   
    	StudentDAO studentDAO=new StudentDAO();     	
    	studentDAO.CreateStudent(); 		    	    	    	    	    	    	   
    	
    }
}