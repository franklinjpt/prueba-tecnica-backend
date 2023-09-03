package com.franklinjpt.pruebaTecnicaBackend.domain.repository;

import com.franklinjpt.pruebaTecnicaBackend.domain.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepository {
    List<Person> getAll();
    Optional<Person> getPersonbyId(Long id);
    Optional<Person> getPersonbyDocumentNumber(String documentNumber);
    Person save(Person person);
    void delete(Long id);
}
