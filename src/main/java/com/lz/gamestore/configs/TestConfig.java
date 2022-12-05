package com.lz.gamestore.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lz.gamestore.services.DBService;

@Configuration
@Profile("test")
public class TestConfig {
	@Autowired
	private DBService dbServ;
	@Bean
	public void instantiateDB() {
		this.dbServ.instantiateDB();
	}
}
