package com.domain.functionalProgramming;

import java.util.List;

public class FP02Structured {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Integer> numbers = List.of(1,2,3,5);

		System.out.println( sumOfSquare(numbers));
		
	}

	private static int add(List<Integer> numbers) {

		int sum =0;
		for (int number : numbers) {
			sum += number;
		}
		return sum;
	}

	private static int sumOfSquare(List<Integer> numbers) {

		int squareSum=0;
		for (Integer integer : numbers) {
			squareSum=squareSum+(integer *integer);
			System.out.println(squareSum);
			
		}
		return squareSum;
	}


}
