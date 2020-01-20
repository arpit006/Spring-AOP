package com.arpit.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Date;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
@Configuration
@Aspect
public class AspectConfiguration {

    /**
     * We can perform all logical operations on Pointcuts and make them work. All the && || etc operators work
     */

    @Before("savePointCut()")
    public void save(JoinPoint joinPoint) {
//        System.out.println(joinPoint);
//        Arrays.stream(joinPoint.getArgs()).forEach(t -> System.out.println("Args : " + t + " " ));
        System.out.println("Aspect :: BEFORE SAVE method + "+ joinPoint.getSignature() +" + called at " + new Date() );
    }

    @After("savePointCut()")
    public void afterSave(JoinPoint joinPoint) {
        System.out.println("Aspect :: AFTER SAVE method + "+ joinPoint.getSignature() +" + called at " + new Date() );
    }

    @Pointcut("execution(* save(..))")
    public void savePointCut(){}

    @Before("deletePointCut()")
    public void delete(JoinPoint joinPoint) {
        System.out.println("Aspect :: BEFORE DELETE method + "+ joinPoint.getSignature() +" + called at " + new Date() );
    }

    @After("deletePointCut()")
    public void afterDelete(JoinPoint joinPoint) {
        System.out.println("Aspect :: AFTER DELETE method + "+ joinPoint.getSignature() +" + called at " + new Date() );
    }

    @Pointcut("execution(* delete(..))")
    public void deletePointCut(){}

    @Before("updatePointCut())")
    public void update(JoinPoint joinPoint) {
        System.out.println("Aspect :: BEFORE UPDATE method + "+ joinPoint.getSignature() +" + called at " + new Date() );
    }

    @After("updatePointCut()")
    public void afterUpdate(JoinPoint joinPoint) {
        System.out.println("Aspect :: AFTER UPDATE method + "+ joinPoint.getSignature() +" + called at " + new Date() );
    }

    /**
     * This method will create a PointCut (REGEX) which can be used for all the advices.
     */
    @Pointcut("execution(* update(..))")
    public void updatePointCut() {}

    @Before("findPointCut()")
    public void find(JoinPoint joinPoint) {
        System.out.println("Aspect :: BEFORE FIND method + "+ joinPoint.getSignature() +" + called at " + new Date() );
    }

    @After("findPointCut()")
    public void afterFind(JoinPoint joinPoint) {
        System.out.println("Aspect :: AFTER FIND method + "+ joinPoint.getSignature() +" + called at " + new Date() );
    }

    @Pointcut("execution(* find(..))")
    public void findPointCut() {}

    @Before("execution(* findAll())")
    public void findAll(JoinPoint joinPoint) {
        System.out.println("Aspect :: BEFORE FIND ALL method + "+ joinPoint.getSignature() +" + called at " + new Date() );
    }

    @Around("execution(* com.arpit.aop.business.BaseRepository.savePerson(..))")
    public Object aroundSave(JoinPoint joinPoint) {
        System.out.println("Aspect :: AROUND FIND ALL method + " + joinPoint.getSignature() + " called at " + new Date());
        System.out.println("Target : " + joinPoint.getTarget());
        System.out.println("Static Part : " + joinPoint.getStaticPart());
        System.out.println(joinPoint.getStaticPart().getId() + joinPoint.getStaticPart().getKind() + joinPoint.getStaticPart().getSignature());
        System.out.println("This : " + joinPoint.getThis());
        Arrays.stream(joinPoint.getArgs()).forEach(t -> System.out.println("Arguments : " + t));
        Class<?> target = joinPoint.getTarget().getClass();
//        joinPoint.getStaticPart().
        return null;
    }

    /**
     * For all the methods inside the class
     */
    @Before("within(com.arpit.aop.business.BaseRepository)")
    public void withinRepoClass(JoinPoint joinPoint) {
        System.out.println("Aspect :: WITHIN BaseRepository methods + " + joinPoint.getSignature() + " called at " + new Date());
    }

    /**
     * To advice all the methods taking Person as argument
     */
    /*@Pointcut("args(com.arpit.aop.business.Person)")
    public void argsPointCut() {}

    @Before("argsPointCut()")
    public void argsAdvice(JoinPoint joinPoint) {
        System.out.println("Aspect :: ARGS " + joinPoint.getSignature() + " called at " + new Date());
    }*/

    //TODO Internet Proxy using AOP
}
