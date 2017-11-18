package com.igate.pl;
import com.igate.dao.*;

public class Main 
{
    
    public static void main(String[] args) 
    {
    	//Calls the DAO method directly from main
    	StudentDAO studentDAO=new StudentDAO();     	
    	studentDAO.simpleQueryFilter();
    	    		    	    	    	    	    	    	    
    	
    }
}