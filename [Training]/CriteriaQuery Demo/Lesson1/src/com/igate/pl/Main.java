package com.igate.pl;
import java.util.*;

import java.sql.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import com.igate.dao.*;

public class Main 
{
    
    public static void main(String[] args) 
    {
    	StudentDAO studentDAO=new StudentDAO();
    	
    	studentDAO.prepareTestData();
    	
    	studentDAO.simpleCriteriaWithNoRestriction();
    	
    	studentDAO.criteriaWithRestrictionAndProjection();
    	
    	
    	studentDAO.criteriaWithMultipleProjections();
    	
    	studentDAO.criteriaWithGroupingResultsetWithProjections();
    	
    	studentDAO.simpleCriteriaWithPaging();
    	
    	studentDAO.criteriaWithTwoConditions();
    	
    	studentDAO.criteriaWithRestrictionLike();
    	
    	studentDAO.criteriaWithRestrictionOr();
    	
    	studentDAO.criteriaWithDISTINCT_ROOT_ENTITY();
    	
    	studentDAO.criteriaWithOrder();    	    	    	    	    	    	    	
    	
    	
    }
}