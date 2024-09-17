package com.example.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Aspect
@Component
public class ParameterAop {

    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    private void cut() {}

    @Before("cut()")
    public void before(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();

        System.out.println(method.getDeclaringClass().getName() + " / " + method.getName());


        Object[] args = joinPoint.getArgs();

        Arrays.stream(args).forEach(obj ->{
            System.out.println("type : "+ obj.getClass().getSimpleName());
            System.out.println("val : "+ obj);
        });
    }

    @AfterReturning(value = "cut()", returning = "returnValue")
    public void afterReturn(JoinPoint joinPoint, Object returnValue) {
        System.out.println("returnValue : "+ returnValue);
    }
}
