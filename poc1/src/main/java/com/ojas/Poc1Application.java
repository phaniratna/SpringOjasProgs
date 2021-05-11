package com.ojas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
		"com.ojas.model","com.ojas.repos", "com.ojas.service"})
public class Poc1Application {

	public static void main(String[] args) {
		SpringApplication.run(Poc1Application.class, args);
	}

}
