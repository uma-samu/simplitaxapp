package com.spring.gst.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;


@Configuration
public class AppConfig {
	
	@Bean(name="mysqlDS")
//	@ConfigurationProperties(value="spring.datasource.dev")
	@ConfigurationProperties(value="spring.datasource")
	public DataSource mysqlDataSource(){
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name="mysqlTemplate")
	public JdbcTemplate mysqlTemplate(@Qualifier("mysqlDS") DataSource ds){
		return new JdbcTemplate(ds);
	}

	/*@Bean
	public WebMvcConfigurer corsConfigurer(CorsRegistry registry){
		return new WebMvcConfigurerAdapter() {
		
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/crud/**")
						.allowedOrigins("http://localhost:4200")
						.allowedMethods("GET","PUT","POST","DELETE");
				
				
			}
		
		};
	}*/
}
