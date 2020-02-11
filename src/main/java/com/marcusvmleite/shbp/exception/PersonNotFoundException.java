package com.marcusvmleite.shbp.exception;

import lombok.Getter;

@Getter
public class PersonNotFoundException extends RuntimeException {

    private String message;

    public PersonNotFoundException(String message) {
        super();
        this.message = message;
    }

}
