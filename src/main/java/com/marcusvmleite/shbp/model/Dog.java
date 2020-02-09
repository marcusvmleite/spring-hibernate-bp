package com.marcusvmleite.shbp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "DOG")
public class Dog {

    @Id
    @GeneratedValue
    private Integer id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person")
    private Person person;

    @Column
    private String name;

    @Column
    private String breed;

    @Version
    private Integer version;

}
