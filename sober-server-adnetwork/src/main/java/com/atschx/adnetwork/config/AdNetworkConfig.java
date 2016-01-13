package com.atschx.adnetwork.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
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

}
