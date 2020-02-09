package com.marcusvmleite.shbp.controller;

import com.marcusvmleite.shbp.model.Dog;
import com.marcusvmleite.shbp.model.Person;
import com.marcusvmleite.shbp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping("/{id}")
    public Person get(@PathVariable Integer id) {
        Person person = service.get(id);
        for (Dog dog : person.getDogs()) {
            System.out.println(dog.getBreed());
        }
        return person;
    }

    @PostMapping
    public void create() {
        service.create();
    }

    @PutMapping
    public void update() {
        service.update();
    }

}
