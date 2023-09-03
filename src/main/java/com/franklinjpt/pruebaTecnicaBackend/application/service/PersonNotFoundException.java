package com.franklinjpt.pruebaTecnicaBackend.application.service;

public class PersonNotFoundException extends RuntimeException{
    public PersonNotFoundException(String message) {
        super(message);
    }
}
