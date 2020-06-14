package com.poc.dbserver.config;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "medsEntityManagerFactoryRef", basePackages = "com.poc.dbserver.service.meds.repo", transactionManagerRef = "medsTransactionManagerRef")
public class MedsDBConfig {

	@Value("${spring.meds.jpa.hibernate.ddl-auto}")
	private String ddl;

	@Value("${spring.meds.jpa.hibernate.dailect}")
	private String dialect;

	@Bean(name = "medsDataSource")
	@ConfigurationProperties(prefix = "spring.meds.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();

	}

	@Bean(name = "medsEntityManagerFactoryRef")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,
			@Qualifier("medsDataSource") DataSource datasource) {
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", ddl);
		properties.put("hibernate.dialect", dialect);
		return builder.dataSource(datasource).properties(properties).packages("com.poc.dbserver.model")
				.persistenceUnit("Medication").build();

	}
	
	@Bean(name = "medsTransactionManagerRef")
	public PlatformTransactionManager transactionManager(@Qualifier("medsEntityManagerFactoryRef")EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
		
	}

}
