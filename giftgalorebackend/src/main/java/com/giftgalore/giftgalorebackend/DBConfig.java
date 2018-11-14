package com.giftgalore.giftgalorebackend;

import java.util.Properties;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.giftgalore")
public class DBConfig {


	@Bean("mydatasource")
	DataSource getDataSource() {
		BasicDataSource basicdatasource = new BasicDataSource();
		basicdatasource.setDriverClassName("org.h2.Driver");
		basicdatasource.setUrl("jdbc:h2:tcp://localhost/~/test");
		basicdatasource.setUsername("sa");
		basicdatasource.setPassword("sa");
		return basicdatasource;
	}

	// 2.Language understood by db
	@Bean("myproperties")
	Properties myDbProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.show_sql", "true");
		return properties;
	}

	// 3.establish connection
	@Autowired
	@Bean("sessionfactory")
	LocalSessionFactoryBean createSessionFactory(DataSource mydatasource, Properties myproperties) {
		LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
		bean.setDataSource(mydatasource);
		bean.setHibernateProperties(myproperties);
		bean.setPackagesToScan("com.giftgalore.giftgalorebackend.model");
		return bean;
	}
	
	@Autowired
	@Bean
	HibernateTransactionManager htm(SessionFactory sessionfactory)
	{
		HibernateTransactionManager ht=new HibernateTransactionManager();
		ht.setSessionFactory(sessionfactory);
		return ht;
	}

}
