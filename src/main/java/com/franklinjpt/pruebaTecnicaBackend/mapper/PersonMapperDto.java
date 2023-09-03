package com.franklinjpt.pruebaTecnicaBackend.mapper;

import com.franklinjpt.pruebaTecnicaBackend.application.dto.PersonDto;
import com.franklinjpt.pruebaTecnicaBackend.domain.model.Person;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapperDto {
    PersonDto toDto(Person person);
    List<PersonDto> toDtos(List<Person> people);
    Person fromDto(PersonDto personDto);
    List<Person> fromDtos(List<PersonDto> peopleDtos);
}
