package com.franklinjpt.pruebaTecnicaBackend.application.service;

public class DuplicatePersonException extends RuntimeException {
    public DuplicatePersonException(String message) {
        super(message);
    }
}
