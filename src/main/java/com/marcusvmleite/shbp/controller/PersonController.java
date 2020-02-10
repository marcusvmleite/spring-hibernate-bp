package com.marcusvmleite.shbp.controller;

import com.marcusvmleite.shbp.model.Dog;
import com.marcusvmleite.shbp.model.Person;
import com.marcusvmleite.shbp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private PersonService service;

    @Autowired
    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> get(@PathVariable Long id) {
        Person person = service.get(id);
        for (Dog dog : person.getDogs()) {
            System.out.println(dog.getBreed());
        }
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Person>> create() {
        return new ResponseEntity<>(service.create(), HttpStatus.CREATED);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> update() {
        return new ResponseEntity<>(service.update(), HttpStatus.OK);
    }

}
