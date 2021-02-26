package com.domain.functionalProgramming;

import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP03FunctionalInterfaceAsVariable {
	
	public static void main(String[] args) {
		
		
		
		List<Integer> numbers = List.of(4,5,6,1 ,7,12,13);
		
		Predicate<? super Integer> evenPredicate = x->x%2==0;
		Predicate<? super Integer> oddPredicate = x->x%2!=0;
		
		/*
		 * filterAndPrint(numbers, evenPredicate);
		 * filterAndPrint(numbers,oddPredicate);
		 */
		filterAndPrint(numbers, x->x%5==0);
		
		
		System.out.println(mapAndCreateList(numbers,x-> x*x*x));
}

	private static List<Integer> mapAndCreateList(List<Integer> numbers, Function<Integer, Integer> mapFunction) {
		
		return numbers.stream().map(mapFunction).collect(Collectors.toList());
	}
	
	

	public static void filterAndPrint(List<Integer> numbers, Predicate<? super Integer> predicate) {
		numbers.stream()
		.filter(predicate)
		.forEach(System.out::println);
	}
	

}
