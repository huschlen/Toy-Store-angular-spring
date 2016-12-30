package com.naoko.inventory.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.naoko.inventory.dao.IToyDAO;
import com.naoko.inventory.dao.ToyDAO;
import com.naoko.inventory.entity.Toy;

/**
 * Configuration for integration tests.
 * 
 * @author	Naoko Huschle
 * @since	2016-12-20
 *
 */
  
@Configuration
@EnableTransactionManagement
public class TestDAOConfig {  
	@Bean  
	public IToyDAO toyDao() {  
		return new ToyDAO();  
	}
	@Bean
	public HibernateTemplate hibernateTemplate() {
		return new HibernateTemplate(sessionFactory());
	}
	@Bean
	public SessionFactory sessionFactory() {
		return new LocalSessionFactoryBuilder(getDataSource())
		   .addAnnotatedClasses(Toy.class)
		   .buildSessionFactory();
	}
	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/toystore");
		dataSource.setUsername("root");
		dataSource.setPassword("");		 
	    return dataSource;
	}
	@Bean
	public HibernateTransactionManager hibTransMan(){
		return new HibernateTransactionManager(sessionFactory());
	}
}  
 