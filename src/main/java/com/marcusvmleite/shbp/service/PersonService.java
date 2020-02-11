package com.marcusvmleite.shbp.service;

import com.marcusvmleite.shbp.exception.PersonNotFoundException;
import com.marcusvmleite.shbp.model.*;
import com.marcusvmleite.shbp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public List<Person> create() {
        Person person1 = new Person();
        person1.setName(UUID.randomUUID().toString());
        Dog dog1 = new Dog();
        dog1.setBreed("beagle");
        dog1.setName("mayla1");
        dog1.setPerson(person1);
        person1.getDogs().add(dog1);

        PersonDetails pd1 = new PersonDetails();
        pd1.setPerson(person1);
        pd1.setDetails(UUID.randomUUID().toString());
        person1.setDetails(pd1);

        Job job1 = new Job();
        job1.setName(UUID.randomUUID().toString());

        person1.getJobs().add(job1);

        job1.getPersons().add(person1);

        Person person2 = new Person();
        person2.setName(UUID.randomUUID().toString());
        Dog dog2 = new Dog();
        dog2.setBreed("beagle");
        dog2.setName("mayla2");
        dog2.setPerson(person2);
        person2.getDogs().add(dog2);

        Person person3 = new Person();
        person3.setName(UUID.randomUUID().toString());
        Dog dog3 = new Dog();
        dog3.setBreed("beagle");
        dog3.setName("mayla3");
        dog3.setPerson(person3);
        person3.getDogs().add(dog3);

        List<Person> persons = Arrays.asList(person1, person2, person3);

        //repository.saveAll(persons);
        repository.save(person1);
        repository.save(person2);
        repository.save(person3);

        return persons;
    }

    public Person findBy(Long id) {
        Optional<Person> person = repository.findById(id);
        return person.orElseThrow(() -> new PersonNotFoundException("Could not find Person with ID [" + id + "]."));
    }

    @Transactional
    public Person update() {
        Person person = repository.findById(1L).get();
        person.setName("mudou");
        return person;
    }

}
