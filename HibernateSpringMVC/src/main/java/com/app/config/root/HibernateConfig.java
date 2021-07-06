package com.app.config.root;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.app.config.repo","com.app.config.entity"})
public class HibernateConfig {
	
	@Autowired
    private ApplicationContext context;
 
	//@Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.app.config.entity");
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }
	
	
	  @Bean 
	  public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
	  
	  LocalContainerEntityManagerFactoryBean entityFactory = new LocalContainerEntityManagerFactoryBean();
	  entityFactory.setDataSource(dataSource());
	  entityFactory.setPackagesToScan("com.app.config.entity");
	  entityFactory.setJpaProperties(hibernateProperties());
	  entityFactory.setJpaVendorAdapter(getHibernateJpaVendorAdapter());
	  
	  return entityFactory; }
	 
	
	/*
	 * @Bean public LocalEntityManagerFactoryBean entityManagerFactoryBean() {
	 * 
	 * LocalEntityManagerFactoryBean entityManager = new
	 * LocalEntityManagerFactoryBean();
	 * entityManager.setPersistenceUnitName("PERSISTENCE");
	 * //entityManager.setJpaVendorAdapter(getHibernateJpaVendorAdapter()); return
	 * entityManager;
	 * 
	 * 
	 * }
	 */
	
	@Bean 
	public HibernateJpaVendorAdapter getHibernateJpaVendorAdapter() {
		
		HibernateJpaVendorAdapter adapter =new HibernateJpaVendorAdapter();
		return adapter;
		
	}

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres?ssl=false");
        dataSource.setUsername("postgres");
        dataSource.setPassword("root");

        return dataSource;
    }

	
	 // @Bean 
	  public PlatformTransactionManager hibernateTransactionManager() {
	  HibernateTransactionManager transactionManager = new
	  HibernateTransactionManager();
	  transactionManager.setSessionFactory(sessionFactory().getObject()); return
	  transactionManager; }
	 
    
	
	  @Bean
	  public JpaTransactionManager jpaTransactionManager() {
	  JpaTransactionManager transactionManager = new JpaTransactionManager();
	  transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
	  return transactionManager; }
	 
    
    private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
		/*
		 * hibernateProperties.setProperty( "hibernate.hbm2ddl.auto", "create-drop");
		 */
        hibernateProperties.setProperty(
          "hibernate.dialect", "org.hibernate.dialect.H2Dialect");

        return hibernateProperties;
    }
}
