package com.marcusvmleite.shbp.service;

import com.marcusvmleite.shbp.model.*;
import com.marcusvmleite.shbp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void create() {
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

        repository.saveAll(persons);
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
