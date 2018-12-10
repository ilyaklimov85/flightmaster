package org.ilyaklimov.flightmaster;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@ApplicationScoped
public class AppProperties {
	private Properties properties = null;
	
	@Produces
	private Properties getProperties(){
		if(properties != null && !properties.isEmpty()) return properties;
		
		FacesContext fc = FacesContext.getCurrentInstance();
		URL resource = getClass().getClassLoader().getResource("app.properties");
		if(resource == null){
			fc.addMessage("footer", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Resource not foind", "Resource not foind"));
		}
		
		String path = resource.getPath();
		try {
			properties = new Properties();
			properties.load(new FileInputStream(path));
		} catch (IOException e) {
			fc.addMessage("footer", new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
			e.printStackTrace();
		}
		return properties;
		
	}

}
