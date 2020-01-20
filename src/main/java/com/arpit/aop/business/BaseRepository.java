package com.arpit.aop.business;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
@Repository
public class BaseRepository {

    private Map<String, Person> personMap;

    private List<Person> persons;

    public BaseRepository() {
        this.personMap = new HashMap<>();
        this.persons = new ArrayList<>();
    }

    public Person save(Person person) {
        String id = person.getId();
        if (personMap.containsKey(id)) {
            throw new RuntimeException("Person already exists...");
        }
        personMap.put(id, person);
        return person;
    }

    public Person update(Person person) {
        String id = person.getId();
        if (!personMap.containsKey(id)) {
            throw new RuntimeException("No person with Id : " + id + " found to be updated");
        }
        personMap.put(id, person);
        return person;
    }

    public Person delete(String id) {
        if (!personMap.containsKey(id)) {
            throw new RuntimeException("No Person with Id : " + id + " found to be deleted");
        }
        Person person = personMap.get(id);
        personMap.remove(id);
        return person;
    }

    public Person find(String id) {
        if (!personMap.containsKey(id)) {
            throw new RuntimeException("No Persod with Id : " + id + " found in Database");
        }

        return personMap.get(id);
    }

    public List<Person> findAll() {
        System.out.println("Inside Base Repository");
        return new ArrayList<>(personMap.values());
    }


    public Person savePerson(Person person) {
        persons.add(person);
        return person;
    }
}
