package com.mycompany.myapp06.common.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class AroundLog {
	
	public void beforeLog(JoinPoint jp) {
		System.out.println("beforeLog 메소드!!!!!" +jp.getThis()+ "target name : " + jp.getSignature().getName());
		Object[] args = jp.getArgs();
		for(int i=0; i<args.length; i++) {
			System.out.println("target args : " + i + args[i].toString());
		}
		
	}
//	public void afterLog(JoinPoint jp) {
//		System.out.println("afterLog 메소드!!!!!" + jp.getThis()); // getThis()하면 hashcode가 보인다. 무슨 클래스에 있는 무슨메소드인데. 해당 클래스 객체까지 다 보여줌 즉, 클래스명 보여줌
//		System.out.println("target name : " + jp.getSignature().getName()); // 어느 객체의 메소드명까지 보여줌
//	}
	
	public void afterLog(JoinPoint jp) {
		System.out.println("afterLog 메소드!!!!!" + jp.getThis() + "target name : \" + jp.getSignature().getName()"); 
	}
	
	public void afterReturningLog(JoinPoint jp, Object ro) { 
		System.out.println("afterReturningLog 메소드!!!!!" + jp.getThis() + "target name : " + jp.getSignature().getName());
		if(ro!=null) {
			System.out.println("target return : " + ro.toString());
		}
	}
	
	public void afterReturningDaoLog(JoinPoint jp, Object ro) {
		System.out.println("afterReturningLog 메소드!!!!!" + jp.getThis() + "target name : " + jp.getSignature().getName());
		if(ro!=null) {
			System.out.println("target return : " + ro.toString());
		}
	}
	
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("aroundLog 메소드!!!!!" + pjp.getThis() + "target name : " + pjp.getSignature().getName());
		
		StopWatch sw = new StopWatch();
		sw.start();
		
		Object ro = pjp.proceed();  // 설명
									// 타겟 메소드 실행, 리턴 값이 있다. try, catch 필요!! 근데 thorws로 마감, 만약 타겟 메소드를 실행하다가 오류 발생하면 받아들일만한게 필요하다. 타겟메소드에서 throws를 적어놓은 것이다. 근데 이걸 여기서 실행하다가 Exception을 던지면 그걸 받아서 이걸 다른 곳으로 또 던져준다. 원래 호출했던 곳으로!! 그러기위해 필요하다. 여기서 Try-catch는 하지 않는다. 
		               				// 타겟 메소드 실행 - 타겟 메소드에 throws가 걸려있을 수 있으므로 이 메소드에서도 thorws Throwable 작성해주어야함. try/catch 하지말기!!
		sw.stop();
		System.out.println("메소드 수행시간 : " + sw.getTotalTimeMillis() + "ms");
		if(ro!=null) {
			System.out.println("target return : " + ro.toString());
		}
		return ro;
	}
}
