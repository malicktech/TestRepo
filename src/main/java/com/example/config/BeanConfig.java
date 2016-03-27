package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.bean.JSFSpringBean;
import com.example.ex02.StudentService;
import com.example.ex02.StudentServiceImpl;

@Configuration
public class BeanConfig {

	// ex0
	@Bean
	public JSFSpringBean jsfSpringBean() {
		return new JSFSpringBean();
	}

	// ex02
	@Bean
	public StudentService studentService() {
		return new StudentServiceImpl();
	}

}
