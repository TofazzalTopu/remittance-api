package com.rms.api;

import com.rms.api.util.PasswordUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;


@SpringBootApplication
public class ApiClientApplication {


	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		String cbsdbpass = PasswordUtil.decryptPassword();
		if(Objects.nonNull(cbsdbpass))  System.setProperty("spring.datasource.password", cbsdbpass);
		SpringApplication.run(ApiClientApplication.class, args);
	}


}
