package com.arpit.aop.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
@RestController
@RequestMapping(value = "/aoptest")
public class BaseController {

    @Autowired
    private BaseService baseService;

    @PostMapping(value = "")
    public Person save(@RequestBody Person person) {
        return baseService.save(person);
    }

    @PostMapping(value = "/save")
    public Person savePerson(@RequestBody Person person) {
        return baseService.savePerson(person);
    }

    @GetMapping(value = "")
    public List<Person> findAll() {
        return baseService.findAll();
    }

    @PutMapping(value = "")
    public Person update(@RequestBody Person person) {
        return baseService.update(person);
    }

    @DeleteMapping(value = "/{id}")
    public Person delete(@PathVariable String id) {
        return baseService.delete(id);
    }

    @GetMapping(value = "/{id}")
    public Person findById(@PathVariable String id) {
        return baseService.find(id);
    }
}
