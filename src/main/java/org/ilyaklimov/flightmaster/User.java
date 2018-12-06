package org.ilyaklimov.flightmaster;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

@Entity
@NamedQuery(name = User.FIND_BY_LOGIN, query = "SELECT u FROM User u WHERE u.login = :login")
public class User implements Serializable{
	public static final String FIND_BY_LOGIN = "User.findByLogin";
	
	@Id @GeneratedValue
	private int id;
	private String name;
	private String login;
	private String password;
	private UserRole role;
	
	public User(){};
	
	public User(@NotNull String name, @NotNull String login, @NotNull String password, @NotNull UserRole role){
		this.name = name;
		this.login = login;
		this.password = password;
		this.role = role;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public UserRole getRole() {
		return role;
	}
}
