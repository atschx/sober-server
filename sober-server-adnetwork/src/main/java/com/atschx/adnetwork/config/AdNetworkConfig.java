package com.atschx.adnetwork.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
//@EnableJpaRepositories
//@EnableTransactionManagement
public class AdNetworkConfig {

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {

			/**
			 * 跨域支持
			 */
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/*/**");
			}
		};
	}
	
	@Bean
	  public DataSource dataSource() {

	    EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
	    return builder.setType(EmbeddedDatabaseType.H2).build();
	  }

	  @Bean
	  public EntityManagerFactory entityManagerFactory() {
	    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    vendorAdapter.setGenerateDdl(true);
	
	    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	    factory.setJpaVendorAdapter(vendorAdapter);
	    //com.atschx.adnetwork.domain.model.Role
	    factory.setPackagesToScan("com.atschx.adnetwork.domain.model");
	    factory.setDataSource(dataSource());
	    factory.afterPropertiesSet();
	    return factory.getObject();
	  }

	  @Bean
	  public PlatformTransactionManager transactionManager() {
	    JpaTransactionManager txManager = new JpaTransactionManager();
	    txManager.setEntityManagerFactory(entityManagerFactory());
	    return txManager;
	  }
}
