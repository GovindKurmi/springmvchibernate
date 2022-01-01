package com.gk.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.gk")
@EnableWebMvc
public class EmpConfig {

	@Bean
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/college?useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("boot");
		return dataSource;
	}

	@Bean(name = "sessionFactory")
	public LocalSessionFactoryBean getLocalSession() {
		LocalSessionFactoryBean localSession = new LocalSessionFactoryBean();
		localSession.setHibernateProperties(getProperties());
		localSession.setDataSource(getDataSource());
		localSession.setPackagesToScan(new String[]{"com.gk.model"});

		return localSession;
	}

	@Bean(name = "properties")
	public Properties getProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "true");
		properties.put("student", "com.gk.spring.model.Student");
		return properties;
	}

	@Bean(name = "transactionManager")
	public PlatformTransactionManager hibernateTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getLocalSession().getObject());
		return transactionManager;
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver irv = new InternalResourceViewResolver();
		irv.setPrefix("/WEB-INF/jsp/");
		irv.setSuffix(".jsp");
		return irv;
	}
}
