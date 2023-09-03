package com.franklinjpt.pruebaTecnicaBackend.application.service;

import com.franklinjpt.pruebaTecnicaBackend.application.dto.PersonDto;
import com.franklinjpt.pruebaTecnicaBackend.domain.model.Person;
import com.franklinjpt.pruebaTecnicaBackend.domain.repository.PersonRepository;
import com.franklinjpt.pruebaTecnicaBackend.mapper.PersonMapperDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

        private PersonRepository personRepository;
        private PersonMapperDto personMapperDto;

        @Autowired
        public PersonService(PersonRepository personRepository, PersonMapperDto personMapperDto) {
            this.personRepository = personRepository;
            this.personMapperDto = personMapperDto;
        }

        public List<PersonDto> getAll() {
            List<Person> people = personRepository.getAll();
            if(people.isEmpty()) {
                throw new PersonNotFoundException("No people found in the database");
            }
            return personMapperDto.toDtos(people);
        }

        public PersonDto getPersonbyId(Long id) {
            Person person = personRepository.getPersonbyId(id).orElseThrow(() -> new PersonNotFoundException("Person not found with id: " + id));
            return personMapperDto.toDto(person);
        }

        public PersonDto getPersonbyDocumentNumber(String documentNumber) {
            Person person = personRepository.getPersonbyDocumentNumber(documentNumber).orElseThrow(() -> new PersonNotFoundException("Person not found with document number: " + documentNumber));
            return personMapperDto.toDto(person);
        }

        public PersonDto savePerson(PersonDto personDto) {
            Person person = personMapperDto.fromDto(personDto);

            if (personRepository.getPersonbyDocumentNumber(person.getDocumentNumber()).isPresent()) {
                throw new DuplicatePersonException("Person with document number: " + person.getDocumentNumber() + " already exists");
            } else {
                Person personSaved = personRepository.save(person);
                return personMapperDto.toDto(personSaved);
            }
        }

        public PersonDto updatePerson(Long id, PersonDto personDto) {
            Person person = personRepository.getPersonbyId(id).orElseThrow(() -> new PersonNotFoundException("Person not found with id: " + id));
            person.setFirstName(personDto.getFirstName());
            person.setSecondName(personDto.getSecondName());
            person.setFirstLastName(personDto.getFirstLastName());
            person.setSecondLastName(personDto.getSecondLastName());
            person.setBirthDate(personDto.getBirthDate());
            Person personSaved = personRepository.save(person);
            return personMapperDto.toDto(personSaved);
        }

        public PersonDto updateBirthDate(Long id, PersonDto personDto) {
            Person person = personRepository.getPersonbyId(id).orElseThrow(() -> new PersonNotFoundException("Person not found with id: " + id));
            person.setBirthDate(personDto.getBirthDate());
            Person personSaved = personRepository.save(person);
            return personMapperDto.toDto(personSaved);
        }

        public boolean delete(Long id) {
            Person person = personRepository.getPersonbyId(id).orElseThrow(() -> new PersonNotFoundException("Person not found with id: " + id));
            personRepository.delete(person.getId());
            return true;
        }
}
