package com.dskow.downloader.service.jds.init;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * The class keeps Spring Boot MVC features, and just adds additional MVC
 * configuration (interceptors, formatters, view controllers etc.)
 * 
 * @author dskowronski@dskow.com
 *
 */
@Configuration
@ConfigurationProperties(prefix = "dskow.cors")
public class CorsSettings {

	final private Logger log = LoggerFactory.getLogger(CorsSettings.class);
	private List<String> origins = new ArrayList<String>();

	public CorsSettings() {
		log.debug("construct CorsSettings");
	}

	public List<String> getOrigins() {
		return this.origins;
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		if (origins != null) {
			log.debug("corsOrgins=" + origins);
		} else {
			log.error("corsOrgins=null");
		}
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins(origins.toArray(new String[origins.size()]));
			}
		};
	}
}