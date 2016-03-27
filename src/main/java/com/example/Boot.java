package com.example;

import org.springframework.boot.SpringApplication;

import com.example.config.AppConfig;


public class Boot {

	public static void main(String[] args) {
		SpringApplication.run(AppConfig.class, args);
//		SpringApplication.run(new Class[]  {ApplicationBoot.class, Initializer.class}, args);
	}
	

}
