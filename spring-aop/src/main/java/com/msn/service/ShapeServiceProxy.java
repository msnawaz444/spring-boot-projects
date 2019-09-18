package com.msn.service;

import com.msn.aspect.LoggingAspect;
import com.msn.model.Circle;

public class ShapeServiceProxy extends ShapeService {

	public Circle getCircle() {
		new LoggingAspect().loggingAdvice();
		return super.getCircle();
	}
}
