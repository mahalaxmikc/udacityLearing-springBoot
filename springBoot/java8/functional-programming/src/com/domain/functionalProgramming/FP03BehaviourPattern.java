package com.domain.functionalProgramming;

import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP03BehaviourPattern {
	
	public static void main(String[] args) {
		
		
		
		List<Integer> numbers = List.of(4,5,6);
		
		Predicate<Integer> isEvenPredicate = num-> num%2==0;
		
		Function< Integer,Integer> squareFunction = num->num*num;
		
		Function< Integer,String> stringFunction = num->num + "added";
		
		Consumer<Integer> sysoutConumer = System.out::println;
		
		BinaryOperator<Integer> sumIntegers = (x,y) ->x+y;
		

		
		Predicate<Integer> isEvenPredicate2 =  new Predicate<Integer>() {
			@Override
			public boolean test(Integer num) {
				return num%2==0;
			}
		};
		
	
		Function< Integer,Integer> squareFunction2 = new Function<Integer, Integer>() {
			
			@Override
			public Integer apply(Integer num) {
				return num* num;
			}
		};
				
	
		Consumer<Integer> sysoutConumer2 = new Consumer<Integer>() {
			
			@Override
			public void accept(Integer t) {
				System.out.println(t);
				
			}
		}; 
		
		
		
	//	  numbers.stream() .filter(isEvenPredicate2) .map(squareFunction2).forEach(sysoutConumer2);
		 
		
		
			/*
			 * Optional<Integer> sum=numbers.stream().reduce(Integer::sum);
			 * System.out.println(sum.get());
			 */
		
		BinaryOperator<Integer> accumulator = new  BinaryOperator<Integer>() {
			
			@Override
			public Integer apply(Integer x, Integer y) {
				return x+y;
			}
		};
		
		
		Integer sum=numbers.stream().reduce(0,sumIntegers);
		sysoutConumer.accept(sum);
		
		sysoutConumer.accept(sumIntegers.apply(7, 9));
		
		
	}

}
