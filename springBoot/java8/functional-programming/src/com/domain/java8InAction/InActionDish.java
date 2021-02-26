package com.domain.java8InAction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InActionDish {

	public static void main(String[] args) {
		List<Dish> menu = Arrays.asList(
				new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("beef", false, 700, Dish.Type.MEAT),
				new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER),
				new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER),
				new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH),
				new Dish("salmon", false, 450, Dish.Type.FISH) );
		
		//gethighCaloriesDish(menu);
		//   isVegetarian(menu);
	//	isMeatType(menu);
		
		//allmatch
		menu.stream().filter(dish-> dish.getCalories()> 300).forEach(System.out::println);
		System.out.println(menu.stream().allMatch(dish-> dish.getCalories()>100));
		System.out.println(menu.stream().noneMatch(dish->dish.isVegetarian()));
		System.out.println(menu.stream().anyMatch
				(dish->dish.isVegetarian()));
	}

	
	public static void gethighCaloriesDish(List<Dish> menuItems){
		 
		menuItems.stream()
		.filter(dish -> dish.getCalories() >= 300)
		.sorted(Comparator.comparing(dish->dish.getCalories())).sorted(Comparator.reverseOrder())
		.map(dish->dish.getName()+":"+dish.getCalories())
	  .skip(2)
	 //   .limit(3)
		.forEach(System.out::println);
	}
	
	public static void isVegetarian(List<Dish> menuItems){
		 
		menuItems.stream()
		.distinct()
		.filter(Dish::isVegetarian)
		.sorted()
		.map(dish->dish.getName()+":"+dish.getCalories())
		.forEach(System.out::println);
		
	}
	public static  void isMeatType(List<Dish> menuItems) {
		menuItems.stream()
		.distinct()
		.filter(dish-> dish.getType().equals((Dish.Type.MEAT)))
		.limit(2)
		.map(dish->dish.getName()+":"+dish.getCalories())
		.forEach(System.out::println);
		
	}
	
	
	
	
}
