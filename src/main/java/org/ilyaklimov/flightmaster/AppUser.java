package org.ilyaklimov.flightmaster;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@NamedQuery(name = AppUser.FIND_BY_LOGIN, query = "SELECT u FROM AppUser u WHERE u.login = :login")
public class AppUser implements Serializable{
	private static final long serialVersionUID = 5319245803062899009L;

	public static final String FIND_BY_LOGIN = "User.findByLogin";
	
	@Id @GeneratedValue
	private int id;
	@AlphaNumeric
	private String firstName;
	@AlphaNumeric
	private String lastName;
	@NotBlank
	private String login;
	@NotBlank
	private String password;
	@NotNull
	private UserRole role;
	
	public AppUser(){};
	
	public AppUser(String firstName, String lastName, String login, String password, UserRole role){
		this.firstName = firstName;
		this.lastName = lastName;
		this.login = login;
		this.password = password;
		this.role = role;
	}
	
	public int getId() {
		return id;
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

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
}
