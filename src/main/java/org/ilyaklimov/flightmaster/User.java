package org.ilyaklimov.flightmaster;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@Id @GeneratedValue
	private int id;
	private String name;
	
	public void User(String name){
		this.name = name;
	}

}
