package com.example;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.bean.JSFSpringBean;

@SpringBootApplication
public class ApplicationBoot {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationBoot.class, args);
//		SpringApplication.run(new Class[]  {ApplicationBoot.class, Initializer.class}, args);
	}
	
	@Bean
	public JSFSpringBean jsfSpringBean() {
		return new JSFSpringBean();
	}
	
	@Configuration
	@Profile("dev") // classe ou méthode excécuté uniquement si le profil dev est excécuté
	static class ConfigureJSFContextParameters implements ServletContextInitializer {
		
	    @Override
	    public void onStartup(ServletContext servletContext) throws ServletException {
	    	System.err.println("----------------- onStartup -------------------");
	    	
	        servletContext.setInitParameter("javax.faces.DEFAULT_SUFFIX",".xhtml");
	        servletContext.setInitParameter("javax.faces.PARTIAL_STATE_SAVING_METHOD", "true");
	        servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
	        servletContext.setInitParameter("facelets.DEVELOPMENT", "true");
	        servletContext.setInitParameter("javax.faces.FACELETS_REFRESH_PERIOD", "1");
	    }
	    
	    
	}
}
