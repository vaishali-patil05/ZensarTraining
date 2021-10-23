package com.zensar.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@ComponentScan(basePackages = "com.zensar")
@Configuration
public class SpringConfig 
{
	@Bean
	public InternalResourceViewResolver viewresolver()
	{
		
		InternalResourceViewResolver i=new InternalResourceViewResolver();
		i.setPrefix("/WEB-INF/views/");
		i.setSuffix(".jsp");
		return i;
	}
	
	@Bean
	public JdbcTemplate jdbctemplate()
	{
		JdbcTemplate jdbctemplate=new JdbcTemplate();
		jdbctemplate.setDataSource(datasource());
		return jdbctemplate;
	}
	
	
	public DataSource datasource()
	{
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/dbase");
		datasource.setUsername("root");
		datasource.setPassword("shah");
		return datasource;
	}
	
}
