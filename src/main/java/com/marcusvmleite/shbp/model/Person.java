package com.marcusvmleite.shbp.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "PERSON")
public class Person {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date updated;

    @Version
    private Integer version;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "person", orphanRemoval = true)
    private List<Dog> dogs = new ArrayList<>();

}
