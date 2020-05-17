package com.example.demo;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class JPAConfiguration {
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean eManager = new LocalContainerEntityManagerFactoryBean();
		eManager.setDataSource(dataSource());
		eManager.setPersistenceUnitName("demo");
		eManager.setPackagesToScan("com.example.demo.domain");
		
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		eManager.setJpaVendorAdapter(vendorAdapter);
		eManager.setJpaProperties(hibernateProperties());
		
		return eManager;
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://127.0.0.1:5432/ESTUDIANTE");
		dataSource.setUsername("postgres");
		dataSource.setPassword("12345678");
		return dataSource;
	}
	
	Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		return properties;
	}
}