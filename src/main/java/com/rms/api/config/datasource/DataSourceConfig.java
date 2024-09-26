package com.rms.api.config.datasource;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
public class DataSourceConfig {

	@Value("${spring.datasource.password}")
	private String dataSourcePassword;
	
	@Value("${server}")
	private String server;

	public String getDataSourcePassword() {
		return dataSourcePassword;
	}

	public String getServer() {
		return server;
	}

}
