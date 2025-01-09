package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
@ComponentScan(basePackages = "com.example.demo.*")
public class EmpDeptTestJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpDeptTestJwtApplication.class, args);
	}

}
