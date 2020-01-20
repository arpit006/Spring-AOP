package com.arpit.aop.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
@Component
public class CommandLineArgs implements CommandLineRunner {

    @Autowired
    private BaseRepository baseRepository;

    @Override
    public void run(String... args) throws Exception {
        Person person = new Person("1","Arpit",22);
        Person person1 = new Person("2","Prabal",24);
        Person person2 = new Person("3","Saharsh",24);
        Person person3 = new Person("4","Shivam",24);
        Person person4 = new Person("5","Kansal",23);
        baseRepository.save(person);
        baseRepository.save(person1);
        baseRepository.save(person2);
        baseRepository.save(person3);
        baseRepository.save(person4);
    }
}
