package com.arpit.aop.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
@Service
public class BaseService {

    @Autowired
    private BaseRepository baseRepository;

    public Person save(Person person) {
        try {
         return baseRepository.save(person);
        } catch (RuntimeException e) {
            System.out.println("BaseService::SAVE " + e);
        }
        return new Person();
    }

    public Person update(Person person) {
        try {
            return baseRepository.update(person);
        } catch (RuntimeException e) {
            System.out.println("BaseService::UPDATE " + e);
        }
        return new Person();
    }

    public Person delete(String id) {
        try {
            return baseRepository.delete(id);
        } catch (RuntimeException e) {
            System.out.println("BaseService::DELETE " + e);
        }
        return new Person();
    }

    public Person find(String id) {
        try {
            return baseRepository.find(id);
        } catch (RuntimeException e) {
            System.out.println("BaseService::FIND " + e);
        }
        return new Person();
    }

    public List<Person> findAll() {
        return baseRepository.findAll();
    }

    public Person savePerson(Person person) {
        return baseRepository.savePerson(person);
    }
}
