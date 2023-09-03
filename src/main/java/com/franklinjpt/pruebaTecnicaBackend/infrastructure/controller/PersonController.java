package com.franklinjpt.pruebaTecnicaBackend.infrastructure.controller;

import com.franklinjpt.pruebaTecnicaBackend.application.dto.PersonDto;
import com.franklinjpt.pruebaTecnicaBackend.application.service.DuplicatePersonException;
import com.franklinjpt.pruebaTecnicaBackend.application.service.PersonNotFoundException;
import com.franklinjpt.pruebaTecnicaBackend.application.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public ResponseEntity<List<PersonDto>> getAll() {
        return ResponseEntity.ok(personService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> getPersonbyId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(personService.getPersonbyId(id));
    }

    @GetMapping("/document-number/{documentNumber}")
    public ResponseEntity<PersonDto> getPersonbyDocumentNumber(@PathVariable("documentNumber") String documentNumber) {
        return ResponseEntity.ok(personService.getPersonbyDocumentNumber(documentNumber));
    }

    @PostMapping()
    public ResponseEntity<Object> save(@Valid @RequestBody PersonDto personDto) {
        if(personDto.getDocumentNumber() == null || personDto.getDocumentNumber().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The document number is required");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.savePerson(personDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonDto> update(@PathVariable Long id, @Valid @RequestBody PersonDto personDto) {
        PersonDto personDtoUpdated = personService.updatePerson(id, personDto);
        return ResponseEntity.ok(personDtoUpdated);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PersonDto> updateBirthDate(@PathVariable Long id, @RequestBody PersonDto personDto) {
        PersonDto personDtoUpdated = personService.updateBirthDate(id, personDto);
        return ResponseEntity.ok(personDtoUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return new ResponseEntity<>(this.personService.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<String> handlePersonNotFoundException(PersonNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(DuplicatePersonException.class)
    public ResponseEntity<String> handleDuplicatePersonException(DuplicatePersonException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }
}
