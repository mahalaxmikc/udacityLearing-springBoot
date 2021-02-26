package com.domain.functionalProgramming;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FP03BehaviourParameterization {
	
	public static void main(String[] args) {
		
		
		
		List<Integer> numbers = List.of(4,5,6);
		
		Predicate<Integer> isEvenPredicate = num-> num%2==0;
		
		Function< Integer,Integer> squareFunction = num->num*num;
		
		Function< Integer,String> stringFunction = num->num + " Points added";
		
		Consumer<Integer> sysoutConumer = System.out::println;
		
		BinaryOperator<Integer> sumIntegers = (x,y) ->x+y;
		
		Supplier<Integer> generateRandomNumber = () -> {
		
			Random random = new Random();
			return random.nextInt(100);
		};
		
        UnaryOperator<Integer> addThePoints =  (x) -> x+300	;	
        
       BiPredicate<Integer, String> biPredicate = (experience,degree) ->{
    	   return (experience>= 5 && degree.equalsIgnoreCase("BE"));
       };
       
        BiConsumer<Integer, String>     biConsumer =(a,b) -> {
            System.out.println("Expereince :" +a +" Degree:"+b);
        };
        
        BiFunction<Integer, Integer, Integer> biFunction =(x,y) -> {
        	if(x<y)
        	return	y-x;
        	else
        		return x-y;
        };
       
        
	    //numbers.stream() .filter(isEvenPredicate) .map(squareFunction).forEach(sysoutConumer);
		//sysoutConumer.accept(sumIntegers.apply(7, 9));
		//sysoutConumer.accept(generateRandomNumber.get());
		//sysoutConumer.accept(addThePoints.apply(550));
		
        
        System.out.println(biPredicate.test(8,"BE"));
         System.out.println(biFunction.apply(9, 78));
        biConsumer.accept(8,"BE");
        System.out.println(stringFunction.apply(5));
		
	}

}
