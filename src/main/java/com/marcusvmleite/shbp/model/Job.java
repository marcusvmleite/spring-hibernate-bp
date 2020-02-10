package com.marcusvmleite.shbp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "JOB")
public class Job {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "jobs")
    private Set<Person> persons = new HashSet<>();

}
