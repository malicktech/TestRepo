package com.example.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@ComponentScan(basePackages = { "" })
@Import({ JsfConfig.class, BeanConfig.class, WebConfig.class })
public class AppConfig  {



}
