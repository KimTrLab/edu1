package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  //Boot는 @SpringBootApplication 하나로 component-scan, @Configuration, @EnableAutoConfiguration
public class Edu1Application {

	public static void main(String[] args) {
		SpringApplication.run(Edu1Application.class, args);
	}

}
