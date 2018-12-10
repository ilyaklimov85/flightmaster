package org.ilyaklimov.flightmaster;

import java.util.Properties;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Named
@RequestScoped
public class RegistrationController {
	@AlphaNumeric
	private String firstName;
	@AlphaNumeric
	private String lastName;
	@AlphaNumeric
	private String username;
    @NotBlank @Size(min = 5, message="Value must be at least {min} characters long")
	private String password;
    @NotBlank @Size(min = 5, message="Value must be at least {min} characters long")
	private String confirmPassword;
	@Inject
	private Properties appProperties;
	
	@Inject
	UserEJB userEJB;
	
	public String registerUser(){
		if(!password.equals(confirmPassword)){
			String property = appProperties.getProperty("passwordsDontMatch");
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, property, property);
			FacesContext.getCurrentInstance().addMessage("registerForm:registerButton", facesMessage);
			return null;
		}
		AppUser user = new AppUser(firstName, lastName, username, password, UserRole.CUSTOMER);
		userEJB.createUser(user);
		
		return "login.xhtml";
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
