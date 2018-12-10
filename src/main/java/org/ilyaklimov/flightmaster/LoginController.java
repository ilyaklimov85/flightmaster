package org.ilyaklimov.flightmaster;

import java.util.List;
import java.util.Properties;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.validator.constraints.NotBlank;

@Named
@RequestScoped
public class LoginController {
	
	@Inject
	private UserEJB userEJB;
	@Inject 
	private AuthenticationContext ac;
	@NotBlank(message="Please enter login")
	private String login;
	@NotBlank(message="Please enter password")
	private String password;
	@Inject
	Properties properties;
	
	public String loginUser(){
		FacesContext fc = FacesContext.getCurrentInstance();
		List<AppUser> users = userEJB.findUsersByLogin(login);
		String noSuchUserFoundAtLoginMessage = properties.getProperty("noSuchUserFoundAtLoginMessage");
		FacesMessage facesMessage = new FacesMessage(
				FacesMessage.SEVERITY_ERROR, noSuchUserFoundAtLoginMessage,
				noSuchUserFoundAtLoginMessage);
		
		if(users.isEmpty()){
			fc.addMessage("loginForm:loginButton", facesMessage);
			return null;
		}
		
		for (AppUser appUser : users) {
			if(appUser != null && password.equals(appUser.getPassword())){
				ac.setLoggedInUser(appUser);
				return "homePage.xhtml";
			}
		}
		
		fc.addMessage("loginForm:loginButton", facesMessage);
		return null;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
