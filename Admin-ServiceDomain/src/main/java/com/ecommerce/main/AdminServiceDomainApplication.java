package com.ecommerce.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class AdminServiceDomainApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminServiceDomainApplication.class, args);
	}
	@Bean
	public ObjectMapper objt(){
	ObjectMapper obj=new ObjectMapper();
	return obj;
	}

}
