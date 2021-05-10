package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;

@SpringBootApplication
@Configuration
public class MoreToStoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(MoreToStoreApplication.class, args);
	}
//	@Bean
//	@Scope(scopeName = "singleton")
//	public String getHello() {
//	return "hello";
//	}

}
