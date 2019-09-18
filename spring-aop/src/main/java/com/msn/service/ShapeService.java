package com.msn.service;

import com.msn.aspect.Loggable;
import com.msn.model.Circle;
import com.msn.model.Triangle;

public class ShapeService {

	private Circle circle;
	private Triangle triangle;

	@Loggable
	public Circle getCircle() {
		System.out.println("Circle's getter is called!");
		return circle;
	}

	public void setCircle(Circle circle) {
		this.circle = circle;
	}

	public Triangle getTriangle() {
		return triangle;
	}

	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}

}
