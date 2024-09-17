package com.example.aop.aop;

import com.example.aop.dto.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Base64;

@Aspect
@Component
public class DecodeAop {

    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    private void cut() {
    }

    @Pointcut("@annotation(com.example.aop.annotation.Decode)")
    private void enableDecode() {
    }

    @Before("cut() && enableDecode()")
    public void before(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();

        Arrays.stream(args).forEach(obj -> {

            if (obj instanceof User) {
                User user = User.class.cast(obj);

                String base64Email = user.getEmail();
                String email = null;
                try {
                    email = new String(Base64.getDecoder().decode(base64Email), "UTF-8");
                    user.setEmail(email);
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }


            }
        });
    }

    @AfterReturning(value = "cut() && enableDecode()", returning = "returnValue")
    public void afterReturn(JoinPoint joinPoint, Object returnValue) {

        if (returnValue instanceof User) {
            User user = User.class.cast(returnValue);

            String base64Email = user.getEmail();
            String email = user.getEmail();

            user.setEmail(Base64.getEncoder().encodeToString(email.getBytes()));


        }
    }
}
