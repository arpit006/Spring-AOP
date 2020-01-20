package com.arpit.aop.aspect;

import com.arpit.aop.business.BaseRepository;
import com.arpit.aop.business.Person;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
@Configuration
@Aspect
public class AspectConfiguration {

    /**
     * We can perform all logical operations on Pointcuts and make them work. All the && || etc operators work
     */
    int i = 0;

    @Before("savePointCut()")
    public void save(JoinPoint joinPoint) {
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
        System.out.println("Aspect :: BEFORE UPDATE method + "+ joinPoint.getSignature() +" + called at " + new Date());
    }

    @After("updatePointCut()")
    public void afterUpdate(JoinPoint joinPoint) {
        System.out.println("Aspect :: AFTER UPDATE method + "+ joinPoint.getSignature() +" + called at " + new Date());
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
    public Object aroundSave(ProceedingJoinPoint joinPoint) {
        System.out.println("Aspect :: AROUND SAVE method + " + joinPoint.getSignature() + " called at " + new Date());
        System.out.println("Target : " + joinPoint.getTarget());
        System.out.println("Static Part : " + joinPoint.getStaticPart());
        System.out.println(joinPoint.getStaticPart().getId() + joinPoint.getStaticPart().getKind() + joinPoint.getStaticPart().getSignature());
        System.out.println("This : " + joinPoint.getThis());
        Arrays.stream(joinPoint.getArgs()).forEach(t -> System.out.println("Arguments : " + t));
        BaseRepository target = (BaseRepository) joinPoint.getTarget();
        Person person = target.savePerson(new Person("111", "110110011", 10));
//        joinPoint.getStaticPart().
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return person;
    }


    /**
     * For all the methods inside the class
     */
    @Before("within(com.arpit.aop.business.BaseRepository)")
    public void withinRepoClass(JoinPoint joinPoint) {
        System.out.println("Aspect :: WITHIN BaseRepository methods + " + joinPoint.getSignature() + " called at " + new Date());
    }


    /**
     * After completing the method call sucessfully and returning the Object
     */
    @AfterReturning(pointcut = "execution(* com.arpit.aop.business.BaseRepository.save(..))", returning = "returning")
    public void afterSavingPerson(JoinPoint joinPoint, Person returning) {
        System.out.println("Aspect :: AfterReturning Person saved sucessfully in Db at " + new Date());
        System.out.println("Returning :: " + returning.toString());
    }

    /**
     * After throwing Error during method call
     * USE test.http
     */
    @AfterThrowing(pointcut = "execution(* com.arpit.aop.business.BaseRepository.save(..))", throwing = "error")
    public void afterThrowingSave(JoinPoint joinPoint, RuntimeException error) {
        System.out.println("Aspect :: AfterThrowing Person thrown Error at " + new Date());
        System.out.println("EXCEPTION IS :: " + error);
    }

    //TODO Internet Proxy using AOP

    @Around("execution(public * com.arpit.aop.business.BaseRepository.findAll())")
    public List<Person> aroundFindAll(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            System.out.println("Before Advice in Aspect :: AROUND");
            List<Person> proceed = (List<Person>) proceedingJoinPoint.proceed();
            System.out.println("After Advice in Aspect :: AROUND");
            return proceed;
        } catch (Throwable t) {
            System.out.println("On Error " + t);
        }
        return new ArrayList<>();
    }

    @Before("execution(* com.arpit.aop.business.BaseRepository.save(..))")
    public void beforeSave(JoinPoint joinPoint) {
        System.out.println("Aspect Making another method call in @Before annotation ;; ");
        BaseRepository baseRepository = (BaseRepository) joinPoint.getTarget();
        Person randomPerson = new Person("999"+i,"999"+i,999+i);
        Person person = baseRepository.save(randomPerson);
        System.out.println("Save call intercepted by Random person :: " + person.toString());
        System.out.println("All Persons are :: " + baseRepository.findAll());
        i++;
    }


    /**
     * To advice all the methods taking Person as argument
     */
    /*@Pointcut("args(com.arpit.aop.business.Person)")
    public void argsPointCut() {}

    @Before("argsPointCut()")
    public void argsAdvice(JoinPoint joinPoint) {
        System.out.println("Aspect :: ARGS " + joinPoint.getSignature() + " called at " + new Date());

    }

    @Before("args(id)")
    public void beforePersonSave(String id) {
        System.out.println("Aspect :: ARGS  ID -> " +id + " called at " + new Date());
    }*/
}
