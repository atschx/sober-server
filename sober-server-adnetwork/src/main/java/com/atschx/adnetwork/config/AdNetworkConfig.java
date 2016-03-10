package com.atschx.adnetwork.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import net.sf.log4jdbc.sql.jdbcapi.DataSourceSpy;

@Configuration
// @EnableJpaRepositories
// @EnableTransactionManagement
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

//	@Bean
//	public DataSource realDataSource() {
//		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
//	}
//	
//
//	@Bean
//	@Primary
//	public DataSource dataSource() {
//		return new DataSourceSpy(realDataSource());
//	}
	
//	@Bean
//	@Primary
//	public DataSource dataSource() {
//		return new Log4jdbcProxyDataSource(realDataSource());
//	}

//	@Bean
//	public EntityManagerFactory entityManagerFactory() {
//		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//		vendorAdapter.setGenerateDdl(true);
//
//		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//		factory.setJpaVendorAdapter(vendorAdapter);
//		factory.setPackagesToScan("com.atschx.adnetwork.domain.model");
//		factory.setDataSource(dataSource());
//		factory.afterPropertiesSet();
//		return factory.getObject();
//	}
//
//	@Bean
//	public PlatformTransactionManager transactionManager() {
//		JpaTransactionManager txManager = new JpaTransactionManager();
//		txManager.setEntityManagerFactory(entityManagerFactory());
//		return txManager;
//	}
}
