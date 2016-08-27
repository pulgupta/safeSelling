package com.org.safeSelling.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DataSourceConfiguration {
	
	@Profile("development")
	@Bean
	public DataSource embbeddedDataSource(){
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("org.hsqldb.jdbcDriver");
		ds.setUrl("jdbc:hsqldb:file:testdb;shutdown=true");
		ds.setUsername("SA");
		ds.setPassword("");
		ds.setInitialSize(1);
		ds.setMaxActive(5);
		return ds;
	}
	
	@Profile("qa")
	@Bean
	public DataSource Data(){
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("system");
		ds.setPassword("system");
		ds.setInitialSize(5);
		ds.setMaxActive(10);
		return ds;
		
	}
	
	//This transaction manager is required for enabling the transaction
	
	@Profile("development")
	@Bean
	public PlatformTransactionManager txManagerEmbedded() {
		return new DataSourceTransactionManager(embbeddedDataSource());
	}
	
	@Profile("qa")
	@Bean
	public PlatformTransactionManager txManager() {
		return new DataSourceTransactionManager(Data());
	}
	
}
