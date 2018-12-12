package org.ilyaklimov.flightmaster;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

@Named
@SessionScoped
public class AuthenticationContext implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4207336100712519353L;
	
	private AppUser loggedInUser;

	public AppUser getLoggedInUser() {
		return loggedInUser;
	}

	public void setLoggedInUser(@NotNull AppUser loggedInUser) {
		this.loggedInUser = loggedInUser;
	}
	

}
