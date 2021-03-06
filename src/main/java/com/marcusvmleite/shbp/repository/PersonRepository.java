package com.marcusvmleite.shbp.repository;

import com.marcusvmleite.shbp.model.Person;
import com.marcusvmleite.shbp.model.PersonDto;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("SELECT NEW com.marcusvmleite.shbp.model.PersonDto(p.name) FROM Person p WHERE p.id = :id")
    List<PersonDto> findNameById(@Param("id") Long id);

    @EntityGraph(value = "Person.eager")
    Optional<Person> findById(@Param("id") Long id);

}
