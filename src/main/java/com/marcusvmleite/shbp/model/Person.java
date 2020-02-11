package com.marcusvmleite.shbp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@Entity
@Table(name = "PERSON")
@NamedEntityGraph(
        name = "Person.eager",
        attributeNodes = {
                @NamedAttributeNode("dogs"),
                @NamedAttributeNode("jobs"),
                @NamedAttributeNode("details")
        }
)
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date created;

    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date updated;

    @Version
    private Integer version;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private PersonDetails details;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "person", orphanRemoval = true)
    private List<Dog> dogs = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "PERSON_JOB",
            joinColumns = { @JoinColumn(name = "job") },
            inverseJoinColumns = { @JoinColumn(name = "person") })
    private Set<Job> jobs = new HashSet<>();

}
