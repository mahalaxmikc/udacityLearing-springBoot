package com.udacity.springBoot.exercise2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApplicationService {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationService.class, args);
	}


	@Bean
	public String message(){
		System.out.println("Bean message instantiated");
		return "Hello Spring !";
	}

	@Bean
	public String upperMessage(MessageService messageService){
		System.out.println("Bean upperMessage instantiated");
		return messageService.upperCase();
	}

	@Bean
	public String lowerMessage(MessageService messageService){
		System.out.println("Bean lowerMessage instantiated");
		return messageService.lowerCase();
	}






}
