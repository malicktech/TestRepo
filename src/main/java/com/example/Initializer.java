package com.example;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;

/**
 * build with Spring Boot app as an executable jar with an embedded Tomcat 7 : the WebApplicationInitialier is NOT called when the application is started.
 * 
 * WebApplicationInitializer - the initializer works fine when I build a war and deploy it to a standalone Tomcat 7.
 * 
 * to register a  JSF servlet to servlet Context  : solved it just with using a ServletContextInitializer 
 */

/* for deploy war in STANDALONE tomcat */
//import org.springframework.web.WebApplicationInitializer;
// public class Initializer implements WebApplicationInitializer {
// @Override
// public void onStartup(ServletContext servletContext) throws ServletException {
//		System.err.println("------------------------------------");
//	}
//}

 /* for EMBEDDED tomcat*/ 
//@Configuration
//public class Initializer implements ServletContextInitializer {
//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		System.err.println("------------------------------------");
//	}
//}


public class Initializer {
}