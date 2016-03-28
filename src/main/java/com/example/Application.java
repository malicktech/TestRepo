package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

import com.example.config.AppConfig;

// @SpringBootApplication
@EnableAutoConfiguration
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
