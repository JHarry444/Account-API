package com.qa.account.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.qa.account.util.NumberGenerator;

@Configuration
public class AppConfig {

	@Bean
	public NumberGenerator numberGenerator() {
		return new NumberGenerator(6);
	}
}
