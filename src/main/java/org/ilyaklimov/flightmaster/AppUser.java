package org.ilyaklimov.flightmaster;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@NamedQueries(value = { 
		@NamedQuery(name = AppUser.FIND_BY_LOGIN, query = "SELECT u FROM AppUser u WHERE u.login = :login"), 
		@NamedQuery(name = AppUser.FIND_ALL, query = "SELECT u FROM AppUser u")
})
public class AppUser implements Serializable{
	private static final long serialVersionUID = 5319245803062899009L;

	public static final String FIND_BY_LOGIN = "User.findByLogin";
	public static final String FIND_ALL = "User.findAll";

	@AlphaNumeric
	private String firstName;
	@AlphaNumeric
	private String lastName;
	@Id
	private String login;
	@NotBlank
	private String password;
	@NotNull @Enumerated(EnumType.STRING)
	private UserRole role;
	
	public AppUser(){};
	
	public AppUser(String firstName, String lastName, String login, String password, UserRole role){
		this.firstName = firstName;
		this.lastName = lastName;
		this.login = login;
		this.password = password;
		this.role = role;
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
