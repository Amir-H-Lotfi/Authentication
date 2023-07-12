package com.site.jpa.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    @Around("@annotation(com.site.jpa.aop.Log)")
    public Object log(ProceedingJoinPoint point) throws Throwable {
        return point.proceed();
    }
}
