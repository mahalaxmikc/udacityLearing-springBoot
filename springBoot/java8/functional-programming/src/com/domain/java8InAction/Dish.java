package com.domain.java8InAction;

public class Dish implements Comparable<Dish>{
	private final String name;
	private final boolean vegetarian;
	private final Integer calories;
	private final Type type;
	
	public Dish(String name, boolean vegetarian, int calories, Type type) {
		this.name = name;
		this.vegetarian = vegetarian;
		this.calories = calories;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	public boolean isVegetarian() {
		return vegetarian;
	}
	public Integer getCalories() {
		return calories;
	}
	public Type getType() {
		return type;
	}
	
	@Override

	public String toString() {
		return name;
	}
	
	public enum Type { MEAT, FISH, OTHER }

	@Override
	public int compareTo(Dish o) {
		return this.getCalories().compareTo(o.getCalories());
	}
}
