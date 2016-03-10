package com.atschx.adnetwork.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import net.sf.log4jdbc.sql.jdbcapi.DataSourceSpy;

@Configuration
@Profile("prod")
public class DataSourceConfig {

	@Value("${spring.datasource.username}")
	private String user;

	@Value("${spring.datasource.password}")
	private String password;
	
	@Value("${spring.datasource.poolName}")
	private String poolName;

	@Value("${spring.datasource.url}")
	private String dataSourceUrl;

	@Value("${spring.datasource.dataSourceClassName}")
	private String dataSourceClassName;

	@Value("${spring.datasource.connectionTimeout}")
	private int connectionTimeout;

	@Value("${spring.datasource.maxLifetime}")
	private int maxLifetime;

	@Bean
	public DataSource primaryDataSource() {

		Properties dsProps = new Properties();
		dsProps.put("url", dataSourceUrl);
		dsProps.put("user", user);
		dsProps.put("password", password);
		dsProps.put("prepStmtCacheSize", 250);
		dsProps.put("prepStmtCacheSqlLimit", 2048);
		dsProps.put("cachePrepStmts", Boolean.TRUE);
		dsProps.put("useServerPrepStmts", Boolean.TRUE);

		Properties configProps = new Properties();
		configProps.put("dataSourceClassName", dataSourceClassName);
		 configProps.put("poolName",poolName);
		// configProps.put("maximumPoolSize",maximumPoolSize);
		// configProps.put("minimumIdle",minimumIdle);
		configProps.put("connectionTimeout", connectionTimeout);
		// configProps.put("idleTimeout", idleTimeout);
		configProps.put("dataSourceProperties", dsProps);

		// A default max pool size of 10 seems reasonable for now, so no need to
		// configure for now.
		HikariConfig hc = new HikariConfig(configProps);
		HikariDataSource ds = new HikariDataSource(hc);
		return ds;
	}
	
	
	@Bean
	@Primary
	public DataSource dataSource() {
		return new DataSourceSpy(primaryDataSource());
	}

}
