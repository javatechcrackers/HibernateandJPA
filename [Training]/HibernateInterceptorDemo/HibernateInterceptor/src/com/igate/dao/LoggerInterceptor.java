package com.igate.dao;

import org.hibernate.EmptyInterceptor;

import java.io.Serializable;
import java.util.*;
import org.hibernate.type.*;
import com.igate.util.*;
import com.igate.entity.Student;
import org.hibernate.*;

public class LoggerInterceptor extends EmptyInterceptor
{
	 
	Session session;
 
	public void setSession(Session session)
	{
		this.session=session;
	}
 
	
	//Called before an object is saved.
	public boolean onSave(Object entity,Serializable id,Object[] state,String[] propertyNames,Type[] types)throws CallbackException
	{
 
		System.out.println("Saving the persistent Object " + entity.getClass() + " with Id" + id); 	
		return super.onSave(entity, id, state, propertyNames, types);
 
	}
 
	
	
	
    //Called before an object is deleted.
	public void onDelete(Object entity, Serializable id,Object[] state, String[] propertyNames, Type[] types) 
	{
		System.out.println("Deleting the persistent Object " + entity.getClass() + " with Id" + id);
 
	}
 
	
	
	//called before commit into database
	public void preFlush(Iterator iterator)
	{
		System.out.println("preFlush is called");
	}	
 
	
	
	//called after committed into database
	public void postFlush(Iterator iterator)
	{
		System.out.println("postFlush is called");
 
	}
 
	
       		
}