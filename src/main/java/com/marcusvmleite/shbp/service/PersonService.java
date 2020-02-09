package com.marcusvmleite.shbp.service;

import com.marcusvmleite.shbp.model.Dog;
import com.marcusvmleite.shbp.model.Person;
import com.marcusvmleite.shbp.model.PersonDto;
import com.marcusvmleite.shbp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    @Transactional
    public void create() {
        Person person = new Person();
        person.setName(UUID.randomUUID().toString());
        Dog dog = new Dog();
        dog.setBreed("beagle");
        dog.setName("mayla");
        dog.setPerson(person);
        person.getDogs().add(dog);
        repository.save(person);
    }

    public Person get(Integer id) {
        Person person = repository.findById(id).get();
        for (Dog dog : person.getDogs()) {
            System.out.println(dog.getBreed());
        }
        List<PersonDto> dto = repository.findNameById(id);
        return person;
    }

    @Transactional
    public void update() {
        Person person = repository.findById(1).get();
        person.setName("mudou");
    }
}
