package com.marcusvmleite.shbp.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonDto {

    private String name;

    public PersonDto(String name) {
        this.name = name;
    }

}
