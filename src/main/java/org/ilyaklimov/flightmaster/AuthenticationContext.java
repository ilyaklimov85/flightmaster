package org.ilyaklimov.flightmaster;

import javax.enterprise.context.SessionScoped;
import javax.validation.constraints.NotNull;

@SessionScoped
public class AuthenticationContext {
	
	private User loggedInUser;

	public User getLoggedInUser() {
		return loggedInUser;
	}

	public void setLoggedInUser(@NotNull User loggedInUser) {
		this.loggedInUser = loggedInUser;
	}
	

}
