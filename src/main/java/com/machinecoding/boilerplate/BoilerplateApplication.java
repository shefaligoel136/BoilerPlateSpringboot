package com.machinecoding.boilerplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BoilerplateApplication {

	public static void main(String[] args) {

		SpringApplication.run(BoilerplateApplication.class, args);
		System.out.println("Hello World!");
	}

}
