package com.domain.functionalProgramming;

import java.util.List;
import java.util.stream.Collectors;

public class FP01Excerises {
	public static void main(String[] args) {


		List<String>courses = List.of("Spring", "AWS", "Spring Thyme & Boot", "Spring","Hibernate & JPA","PCF", "DS", "Python","Spark","Spring Boot & AWS");


		courses.stream() 
		.distinct()
		.forEach(System.out::println);
        print();
		
        courses.stream()
		.distinct()
		.filter(course -> course.contains("Spring"))
		.forEach(System.out::println);
	      print();
		
	      courses.stream()
		.filter(course -> course.length()>=4)
		.forEach(System.out::println);
	      print();
		
	      courses.stream()
	      .distinct()
	      .map(course-> course +":" +course.length())
	      .forEach(System.out::println);
	      
	      List<Integer>courseLenthList=courses.stream().map(course-> course.length()).collect(Collectors.toList());
	      System.out.println(courseLenthList);



	}
	
	private static void print() {
		System.out.println("---------------------------------------------");
	}











}
