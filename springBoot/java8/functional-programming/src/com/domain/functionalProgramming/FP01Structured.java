package com.domain.functionalProgramming;

import java.util.List;

public class FP01Structured {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Integer> numbers = List.of(11, 62, 56, 78, 22, 43, 12, 29, 9, 5);

		printAllListElements(numbers);
		printEvenListElements(numbers);
	}

	private static void printAllListElements(List<Integer> numbers) {
		for (Integer number : numbers) {
			System.out.println(number);
		}

	}

	private static void printEvenListElements(List<Integer> numbers) {

		for (Integer number : numbers) {
			if (number % 2 == 0)
				System.out.println(number);
		}

	}

}
