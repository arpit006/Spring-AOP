package com.arpit.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Date;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
@Configuration
@Aspect
public class AspectConfiguration {

    @Before("execution(* save(..))")
    public void save(JoinPoint joinPoint) {
//        System.out.println(joinPoint);
//        Arrays.stream(joinPoint.getArgs()).forEach(t -> System.out.println("Args : " + t + " " ));
        System.out.println("Aspect :: BEFORE SAVE method + "+ joinPoint.getSignature() +" + called at " + new Date() );
    }

    @After("execution(* save(..))")
    public void afterSave(JoinPoint joinPoint) {
        System.out.println("Aspect :: AFTER SAVE method + "+ joinPoint.getSignature() +" + called at " + new Date() );
    }

    @Before("execution(* delete(..))")
    public void delete(JoinPoint joinPoint) {
        System.out.println("Aspect :: BEFORE DELETE method + "+ joinPoint.getSignature() +" + called at " + new Date() );
    }

    @After("execution(* delete(..))")
    public void afterDelete(JoinPoint joinPoint) {
        System.out.println("Aspect :: AFTER DELETE method + "+ joinPoint.getSignature() +" + called at " + new Date() );
    }

    @Before("execution(* update(..))")
    public void update(JoinPoint joinPoint) {
        System.out.println("Aspect :: BEFORE UPDATE method + "+ joinPoint.getSignature() +" + called at " + new Date() );
    }

    @After("execution(* update(..))")
    public void afterUpdate(JoinPoint joinPoint) {
        System.out.println("Aspect :: AFTER UPDATE method + "+ joinPoint.getSignature() +" + called at " + new Date() );
    }

    @Before("execution(* find(..))")
    public void find(JoinPoint joinPoint) {
        System.out.println("Aspect :: BEFORE FIND method + "+ joinPoint.getSignature() +" + called at " + new Date() );
    }

    @After("execution(* findAll(..))")
    public void afterFind(JoinPoint joinPoint) {
        System.out.println("Aspect :: AFTER FIND method + "+ joinPoint.getSignature() +" + called at " + new Date() );
    }

    @Before("execution(* findAll(..))")
    public void findAll(JoinPoint joinPoint) {
        System.out.println("Aspect :: BEFORE FIND ALL method + "+ joinPoint.getSignature() +" + called at " + new Date() );
    }

    //TODO Internet Proxy using AOP
}
