package com.msn.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

	@Before(" allCircleMethods()")
	public void loggingAdvice(JoinPoint joinPoint) {
	}

	@AfterReturning(pointcut = "args(name)", returning = "returnString")
	public void stringArgumentMethods(String name, Object returning) {
		System.out.println("A method that takes String as argument has been called. The value is: " + name
				+ " The output value is: " + returning);
	}

	@AfterThrowing(pointcut = "args(name)", throwing = "ex")
	public void exceptionAdvice(String name, Exception ex) {
		System.out.println("An exception has been thrown." + ex);
	}

	@Around("@annotation(com.msn.aspect.Loggable)")
	public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
		Object returnValue = null;
		try {
			System.out.println("Before advice");
			returnValue = proceedingJoinPoint.proceed();
			System.out.println("After Returning");
		} catch (Throwable e) {
			System.out.println("After Throwing");
		}
		System.out.println("After Finally");
		return returnValue;
	}

	@Pointcut("execution(* get*())")
	public void allGetters() {
	}

	@Pointcut("within(com.msn.model.Circle)")
	public void allCircleMethods() {
	}

	public void loggingAdvice() {
		System.out.println("Logging from the advice");
	}

}
