package com.example.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@ComponentScan(basePackages = { "com.example" })
@Import({ JsfConfig.class, BeanConfig.class, WebConfig.class })
public class AppConfig  {



}
