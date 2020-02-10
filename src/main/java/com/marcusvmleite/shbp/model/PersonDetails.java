package com.marcusvmleite.shbp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "PERSON_DETAILS")
public class PersonDetails {

    @Id
    private Long id;

    @Column
    private String details;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "id")
    @MapsId
    private Person person;

}
