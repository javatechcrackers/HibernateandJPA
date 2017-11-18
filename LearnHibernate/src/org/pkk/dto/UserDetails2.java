package org.pkk.dto;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/*
 * lets use collection for the address obj instead of having static address obj
 * 
 */

@Entity
@Table(name="USER_DETAILS2")
public class UserDetails2 {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)

	private int userId;
	
	
	private String name;
	
	@ElementCollection(targetClass=Address.class)
	private List<Address> listofAddress= new ArrayList<Address>();
	
	
	public List<Address> getListofAddress() {
		return listofAddress;
	}
	public void setListofAddress(List<Address> listofAddress) {
		this.listofAddress = listofAddress;
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
