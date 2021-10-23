package com.zensar.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@ComponentScan(basePackages = "com.zensar.controller")
@Configuration
public class SpringConfiguration 
{
	
	@Bean
	public InternalResourceViewResolver viewresolver()
	{
		
		InternalResourceViewResolver i=new InternalResourceViewResolver();
		i.setPrefix("/WEB-INF/");
		i.setSuffix(".jsp");
		return i;
	}

}
