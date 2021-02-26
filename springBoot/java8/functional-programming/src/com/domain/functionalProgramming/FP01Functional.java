package com.domain.functionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FP01Functional {
	public static void main(String[] args) {

		List<Integer> numbers = List.of(1, 6, 5, 8, 2, 3, 4, 9, 12, 15);
	    List<Integer> squaredNumbers= squaredNumber(numbers);	 
		
	
		List<Integer> numbers1 = Arrays.asList(1, 2, 3);
		List<Integer> numbers2 = Arrays.asList(3, 4);
		List<int[]> pairs =numbers1.stream()
		.flatMap(i ->
		numbers2.stream()
		.filter(j -> (i + j) % 3 == 0)
		.map(j -> new int[]{i, j})
		)
		.collect(Collectors.toList());

		System.out.println(squaredNumbers);
		
		
	//	printAllListElements(numbers);
	//	printEvenListElements(numbers);
		//printOddListElements(numbers);
	}
	
	
	


	private static List<Integer> squaredNumber(List<Integer> numbers) {
		// TODO Auto-generated method stub
		return numbers.stream().filter(num->num%2==0).map(num-> num*num).collect(Collectors.toList());
	}





	//interger -> integer%2==0
	private static boolean isEven(Integer number) {
		return number%2==0;

	}
	
	private static void printAllListElements(List<Integer> numbers) {
		numbers.stream()
		.forEach(System.out::println);
	}

	private static void printEvenListElements(List<Integer> numbers) {
		//numbers.stream().filter(FP01Functional::isEven).forEach(System.out::println);
		
		numbers.stream()
		.filter(number -> number%2==0)
	    .map(number -> number * number)
		.forEach(System.out::println);
	}
	
	private static void printOddListElements(List<Integer> numbers) {
		//numbers.stream().filter(FP01Functional::isEven).forEach(System.out::println);

		numbers.stream()   
		.filter(number -> number%2!=0)
		.map(number-> number * number * number)
		.forEach(System.out::println);
	}

}
