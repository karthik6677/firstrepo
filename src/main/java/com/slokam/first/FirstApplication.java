package com.slokam.first;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.slokam.first.util.SpringUtil;

import antlr.StringUtils;

@SpringBootApplication
@EntityScan
@EnableJpaRepositories("com.slokam.first.dao")
@ComponentScan({"com.slokam.first.exception","com.slokam.first.controller","com.slokam.first.service","com.slokam.first.util"})
public class FirstApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstApplication.class, args);
	}
	
	@Bean
	public SpringUtil met1() {
		return new SpringUtil();
	}
}
