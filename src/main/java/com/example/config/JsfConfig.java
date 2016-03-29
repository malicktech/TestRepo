package com.example.config;

import java.util.HashSet;
import java.util.Set;

import javax.faces.webapp.FacesServlet;
import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.primefaces.webapp.filter.FileUploadFilter;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.ServletListenerRegistrationBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ServletContextAware;

import com.sun.faces.config.ConfigureListener;
import com.sun.faces.config.FacesInitializer;

/**
 * Configuring faces servlet JSF is just a servlet so both JSF and spring MVC
 * can co-exist
 */
@Configuration
public class JsfConfig implements ServletContextAware {

	/*
	 * WAY 1 - OK - FacesInitializer
	 * =========================================================================
	 */
//	@Bean
//	public ServletRegistrationBean facesServletRegistration() {
//		ServletRegistrationBean servletRegistrationBean = new JsfServletRegistrationBean();
//		return servletRegistrationBean;
//
//	}
	
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

			// FacesInitializer / is a ServletContainerInitializer was
			// bootstrapping FacesServlet
			// It registers FacesServlet with the standard mappings: /faces/,
			// *.jsf, and *.faces

			/** Faces Servlet */
			// ServletRegistration.Dynamic facesServlet =
			// servletContext.addServlet("Faces Servlet", FacesServlet.class);
			// facesServlet.setLoadOnStartup(1);
			// facesServlet.addMapping("*.xhtml");
			// facesServlet.addMapping("*.faces");
			// facesServlet.addMapping("*.jsf");
			// facesInitializer.onStartup(clazz, facesServlet);

		}
	}
	

	
	/*
	 * WAY 2 - OK - FaceServlet
	 * =========================================================================
	 */
	@Bean
	public ServletRegistrationBean facesServletRegistration() {
		System.err.println("----------------- facesServletRegistration -------------------");
		ServletRegistrationBean registration = new ServletRegistrationBean(new FacesServlet(), new String[] { "*.xhtml", "*.faces", "*.jsf" });
		registration.setName("FacesServlet");
		registration.setLoadOnStartup(1);
		return registration;
	}
	
	// ex05
    @Bean
    public FilterRegistrationBean facesUploadFilterRegistration() {
		System.err.println("----------------- facesUploadFilterRegistration -------------------");
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new FileUploadFilter(), facesServletRegistration());
        registrationBean.setName("PrimeFaces FileUpload Filter");
        registrationBean.addUrlPatterns("/*");
        registrationBean.setDispatcherTypes(DispatcherType.FORWARD, DispatcherType.REQUEST);
        return registrationBean;
    }

	@Bean
	public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
		System.err.println("----------------- jsfConfigureListener -------------------");
		return new ServletListenerRegistrationBean<ConfigureListener>(new ConfigureListener());
	}

    
	/**
	 * Add facelet parameter 
	 * 
	 * To get JSF working on Spring Boot without a web.xml or faces-config.xml,
	 * need to force it to load its configuration files via an init parameter on
	 * the ServletContext. An easy way to do that is to implement
	 * ServletContextAware:
	 * 
	 */
	@Override
	public void setServletContext(ServletContext servletContext) {
		System.err.println("----------------- setServletContext -------------------");
		servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
		// Use JSF view templates saved as *.xhtml, for use with Facelets
		servletContext.setInitParameter("javax.faces.DEFAULT_SUFFIX", ".xhtml");
		servletContext.setInitParameter("javax.faces.PARTIAL_STATE_SAVING_METHOD", "true");
		// Enable special Facelets debug output during development
		servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
		servletContext.setInitParameter("facelets.DEVELOPMENT", "true");
		// Causes Facelets to refresh templates during development
		servletContext.setInitParameter("javax.faces.FACELETS_REFRESH_PERIOD", "1");
		servletContext.setInitParameter("encoding", "UTF-8");
		
        servletContext.setInitParameter("primefaces.THEME", "bootstrap");
        servletContext.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", Boolean.TRUE.toString());
        servletContext.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS", Boolean.TRUE.toString());
        servletContext.setInitParameter("primefaces.FONT_AWESOME", Boolean.TRUE.toString());
        servletContext.setInitParameter("primefaces.UPLOADER", "commons");
        

		// Declare Spring Security Facelets tag library
		// servletContext.setInitParameter("javax.faces.FACELETS_LIBRARIES",
		// "/WEB-INF/springsecurity.taglib.xml");
	}
	
//	@Bean
//    public ViewResolver getViewResolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/views/");
//        resolver.setSuffix(".jsf");
//        return resolver;
//    }

	/* End ========================================================================= */
	
	
//	@Configuration	
	// classe ou méthode excécuté uniquement si le profil dev est excécuté
	// @Profile("dev") 
//	static class ConfigureJSFContextParameters implements ServletContextInitializer {
//		@Override
//		public void onStartup(ServletContext servletContext) throws ServletException {
//			System.err.println("----------------- onStartup -------------------");			
//			servletContext.setInitParameter("javax.faces.FACELETS_REFRESH_PERIOD", "1");
//		}
//	}

}
