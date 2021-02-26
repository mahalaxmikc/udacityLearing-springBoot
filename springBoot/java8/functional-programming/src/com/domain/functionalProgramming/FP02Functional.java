package com.domain.functionalProgramming;

import java.util.List;

public class FP02Functional {
	public static void main(String[] args) {


		List<Integer> numbers = List.of(1, 6,0,9);

		//System.out.println(add(numbers));
		System.out.println(max(numbers));
		System.out.println(addSquareNumber(numbers));
	}
	
	
	// int sum =0; for (int number : numbers) { sum += number; } return sum;
	//	0 1
	//	1 6
	//	7 5
	//	12 8
	//	20 2
	//	22 0
	//	22

	private static int sum(int aggregate,int nextnumber) {
		System.out.println(aggregate+" "+nextnumber);
		return aggregate+nextnumber;
	}
	
	private static int max(int a,int b) {
		System.out.println(a +" "+b);
		return (a >= b) ? a : b;
	}
	
	private static int add(List<Integer> numbers) {
		return numbers.stream().
				reduce(0, Integer::sum);
		//.reduce(0, FP02Functional::sum);
		//.reduce(0, (a,b)->a+b);
		
	}

	//0 1
	//1 6
	//6 5
	//6 8
	//8 2
	//8 0
	//8
	private static int max(List<Integer> numbers) {
		return numbers.stream()
				//.reduce(0, FP02Functional::max);
			//	.reduce(0, (a,b) -> (a>=b) ?a:b);
		   .reduce(0, Integer::max);
	}
	
	private static int addSquareNumber(List<Integer> numbers) {
		return numbers.stream()
				.map(number -> number *number ).reduce(0, Integer::sum);
				
	}
	
	
}
