package com.msn.service;

public class FactoryService {

	public Object getBean(String beanType) {
		if(beanType.equals("shapeService")) return new ShapeServiceProxy();
		if(beanType.equals("circle")) return new ShapeService();
		if(beanType.equals("triangle")) return new ShapeService();
		return null;
	}
}
