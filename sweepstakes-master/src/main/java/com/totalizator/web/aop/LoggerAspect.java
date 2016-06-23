package com.totalizator.web.aop;

import com.totalizator.utilits.LogUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by home
 */
@Aspect
@Component
public class LoggerAspect {


//    @Pointcut("execution(* asu_pvh_plasttrade.web.controller.*.*(..))")
//    public void controllersMethods() {
//    }


	@Around("execution(* com.totalizator.web.controller.*.* (..)) ")
	public Object logAroundAdvice(ProceedingJoinPoint jp) throws Throwable {
		Object value = null;
		MethodSignature signature = (MethodSignature) jp.getSignature();
		Method method = signature.getMethod();

		try {
			LogUtils.debug("Aspect calls method: " + method.getName());
			value = jp.proceed();
			LogUtils.debug("Aspect method completed: " + method.getName());
		} catch (Throwable e) {
			LogUtils.error("logger advice: " + e);
			throw e;
		}
		return value;
	}
}