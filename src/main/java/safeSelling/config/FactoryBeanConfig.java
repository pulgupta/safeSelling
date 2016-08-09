package safeSelling.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

@Configuration
public class FactoryBeanConfig {
	
	@Profile("development")
	@Bean
	@Autowired
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource){
		LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
		sfb.setDataSource(dataSource);
		sfb.setPackagesToScan("safeSelling");
		Properties prop = new Properties();
		prop.setProperty("dialect", "org.hibernate.dialect.HSQLDialect");
		//prop.setProperty("dialect", "org.hibernate.dialect.OracleDialect");
		prop.setProperty("hibernate.hbm2ddl.auto", "update");
		sfb.setHibernateProperties(prop);
		return sfb;		
	}
	
	@Profile("qa")
	@Bean
	@Autowired
	public LocalSessionFactoryBean qasessionFactory(DataSource dataSource){
		LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
		sfb.setDataSource(dataSource);
		sfb.setPackagesToScan("safeSelling");
		Properties prop = new Properties();
		prop.setProperty("dialect", "org.hibernate.dialect.OracleDialect");
		prop.setProperty("hibernate.hbm2ddl.auto", "update");
		sfb.setHibernateProperties(prop);
		return sfb;		
	}
}
