package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.bean.JSFSpringBean;

@Configuration
public class BeanConfig {
	
	
	@Bean
	public JSFSpringBean jsfSpringBean() {
		return new JSFSpringBean();
	}

}
