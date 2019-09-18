package com.msn.model;

public class Circle {

	private String name;

	public String getName() {
		System.out.println("Circle's getter is called!");
		return name;
	}

	public void setName(String name) {
		System.out.println("Circle's setter is called!");
		this.name = name;
		throw (new RuntimeException());
	}

	public String setNameAndReturn(String name) {
		this.name = name;
		System.out.println("Circle's setter is called!");
		return name;
	}
}
