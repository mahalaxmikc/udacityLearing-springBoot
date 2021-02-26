package com.udacity.springBoot.annotation;

import com.udacity.springBoot.exercise2.MessageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}


	@Bean
	public String message(){
		System.out.println("Bean message instantiated");
		return "Hello Spring !";
	}

	@Bean
	public String upperMessage(String message){
		System.out.println("UpperMessage :"+message);
		return message.toUpperCase();
	}

	@Bean
	public String lowerMessage(String message){
		System.out.println("LowerMessage :" +message);
		return message.toLowerCase();
	}






}
