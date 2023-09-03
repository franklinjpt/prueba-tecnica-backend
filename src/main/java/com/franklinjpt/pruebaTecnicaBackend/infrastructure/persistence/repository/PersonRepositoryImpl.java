package com.franklinjpt.pruebaTecnicaBackend.infrastructure.persistence.repository;

import com.franklinjpt.pruebaTecnicaBackend.domain.model.Person;
import com.franklinjpt.pruebaTecnicaBackend.domain.repository.PersonRepository;
import com.franklinjpt.pruebaTecnicaBackend.infrastructure.persistence.entity.PersonEntity;
import com.franklinjpt.pruebaTecnicaBackend.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    private CrudPersonRepository crudPersonRepository;
    private PersonMapper mapper;

    @Autowired
    public PersonRepositoryImpl(CrudPersonRepository crudPersonRepository, PersonMapper mapper) {
        this.crudPersonRepository = crudPersonRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Person> getAll() {
        List<PersonEntity> personEntities = (List<PersonEntity>) crudPersonRepository.findAll();
        return mapper.toDomainModel(personEntities);
    }

    @Override
    public Optional<Person> getPersonbyId(Long id) {
        Optional<PersonEntity> person = crudPersonRepository.findById(id);
        return person.map(mapper::toDomainModel);
    }

    @Override
    public Optional<Person> getPersonbyDocumentNumber(String documentNumber) {
        Optional<PersonEntity> person = crudPersonRepository.findByDocumentNumber(documentNumber);
        return person.map(mapper::toDomainModel);
    }

    @Override
    public Person save(Person person) {
        PersonEntity personEntity = mapper.toEntity(person);
        return mapper.toDomainModel(crudPersonRepository.save(personEntity));
    }

    @Override
    public void delete(Long id) {
        crudPersonRepository.deleteById(id);
    }
}
