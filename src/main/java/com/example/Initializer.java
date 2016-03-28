package com.example;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;

/**
 * build with Spring Boot app as an executable jar with an embedded Tomcat 7 : the WebApplicationInitialier is NOT called when the application is started.
 * 
 * WebApplicationInitializer - the initializer works fine when I build a war and deploy it to a standalone Tomcat 7.
 * 
 * to register a  JSF servlet to servlet Context  : solved it just with using a ServletContextInitializer 
 */

/* for deploy war in STANDALONE tomcat 
 * using WebApplicationInitializer class to register DispatcherServlet, ContextLoaderListener and RequestContextListener
 * */
//import org.springframework.web.WebApplicationInitializer;
// public class Initializer implements WebApplicationInitializer {
// @Override
// public void onStartup(ServletContext servletContext) throws ServletException {
//		System.err.println("-----------------Initializer -------------------");
//AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();  
//ctx.register(AppConfig.class);  
//ctx.setServletContext(servletContext);    
//servletContext.addListener(new ContextLoaderListener(ctx));
//servletContext.addListener(new RequestContextListener());
//Dynamic dynamic = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));  
//dynamic.addMapping("/");  
//dynamic.setLoadOnStartup(1);
//	}
//}

// extends SpringBootServletInitializer

 /* for EMBEDDED tomcat*/ 
//@Configuration
//public class Initializer implements ServletContextInitializer {
//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		System.err.println("------------------------------------");
//	}
//}



@Configuration
public class Initializer implements ServletContextInitializer {
 
  @Override
  public void onStartup(ServletContext sc) throws ServletException {
    sc.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", "true");
    sc.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
  }
  
  // add Initializer.class in boot main
}