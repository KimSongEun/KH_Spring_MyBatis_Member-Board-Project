package com.mycompany.myapp06.common.service;

import org.aspectj.lang.JoinPoint;

public class AroundLog {
	public void aroundLog() {
		System.out.println("aroundLog 메소드!!!!!");
	}
	
	public void beforeLog(JoinPoint jp) {
		System.out.println("beforeLog 메소드!!!!!");
		Object[] args = jp.getArgs();
		System.out.println("target name : " + jp.getSignature().getName());
		for(int i=0; i<args.length; i++) {
			System.out.println("target args : " + args[i].toString());
		}
		
	}
	public void afterLog(JoinPoint jp) {
		System.out.println("afterLog 메소드!!!!!");
		System.out.println("target name : " + jp.getSignature().getName());
	}
	
	public void afterReturningLog(JoinPoint jp, Object ro) {
		System.out.println("afterReturningLog 메소드!!!!!");
		System.out.println("target name : " + jp.getSignature().getName());
		if(ro!=null) {
			System.out.println("target return : " + ro.toString());
		}
	}
}
