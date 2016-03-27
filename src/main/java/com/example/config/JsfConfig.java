package com.example.config;

import java.util.HashSet;
import java.util.Set;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.sun.faces.config.FacesInitializer;

/**
 * Configuring faces servlet JSF is just a servlet so both JSF and spring MVC
 * can co-exist
 */
@Configuration
public class JsfConfig {
	
	@Bean
	public ServletRegistrationBean facesServletRegistration() {
		ServletRegistrationBean servletRegistrationBean = new JsfServletRegistrationBean();
		return servletRegistrationBean;
	}

	public class JsfServletRegistrationBean extends ServletRegistrationBean {
		public JsfServletRegistrationBean() {
			super();
		}

		@Override
		public void onStartup(ServletContext servletContext) throws ServletException {
			FacesInitializer facesInitializer = new FacesInitializer();
			Set<Class<?>> clazz = new HashSet<Class<?>>();
			clazz.add(JsfConfig.class);
	        facesInitializer.onStartup(clazz, servletContext);

			
			
	        /** Faces Servlet */
//	        ServletRegistration.Dynamic facesServlet = servletContext.addServlet("Faces Servlet", FacesServlet.class);
//	        facesServlet.setLoadOnStartup(1);
//	        facesServlet.addMapping("*.xhtml");
//	        facesServlet.addMapping("*.faces");
//	        facesServlet.addMapping("*.jsf");	        
//	        facesInitializer.onStartup(clazz, facesServlet);
	        
		}
	}
	
	
	@Configuration
	// @Profile("dev") // classe ou méthode excécuté uniquement si le profil dev est excécuté
	static class ConfigureJSFContextParameters implements ServletContextInitializer {
		
	    @Override
	    public void onStartup(ServletContext servletContext) throws ServletException {
	    	System.err.println("----------------- onStartup -------------------");
	    	
	    	// Use JSF view templates saved as *.xhtml, for use with Facelets
	        servletContext.setInitParameter("javax.faces.DEFAULT_SUFFIX",".xhtml");
	        servletContext.setInitParameter("javax.faces.PARTIAL_STATE_SAVING_METHOD", "true");
	        // Enable special Facelets debug output during development
	        servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
	        servletContext.setInitParameter("facelets.DEVELOPMENT", "true");
	        // Causes Facelets to refresh templates during development
	        servletContext.setInitParameter("javax.faces.FACELETS_REFRESH_PERIOD", "1");
	        
	     // Declare Spring Security Facelets tag library
	        // servletContext.setInitParameter("javax.faces.FACELETS_LIBRARIES", "/WEB-INF/springsecurity.taglib.xml");
	        

	    }
	    
	    
	}
}
