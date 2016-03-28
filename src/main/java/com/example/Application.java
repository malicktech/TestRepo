package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.example.config.BeanConfig;
import com.example.config.JsfConfig;
import com.example.config.WebAppConfig;

// @SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.example" })
@Import({ JsfConfig.class, BeanConfig.class, WebAppConfig.class
	// FacesRewriteConfigurationProvider.class,
	})
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		System.err.println("------------------ Application - main ------------------");
		SpringApplication.run(Application.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		System.err.println("------------------ Application - configure SpringApplicationBuilder  ------------------");
		return application.sources(Application.class, Initializer.class);
	}

}
