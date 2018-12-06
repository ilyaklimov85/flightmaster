package org.ilyaklimov.flightmaster;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


@RequestScoped
@Named
public class LoginController {
	
	@Inject
	private UserEJB userEJB;
	@Inject 
	private AuthenticationContext ac;
	private String login;
	private String password;
	
	public String loginUser(){
		User user = userEJB.findUserByLogin(login);
		if(user != null && password.equals(user.getPassword())){
			ac.setLoggedInUser(user);
			return "homePage.xhtml";
		}else{
			return "";
		}
	}	
}
