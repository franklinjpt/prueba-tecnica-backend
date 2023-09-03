package com.franklinjpt.pruebaTecnicaBackend.mapper;

import com.franklinjpt.pruebaTecnicaBackend.domain.model.Person;
import com.franklinjpt.pruebaTecnicaBackend.infrastructure.persistence.entity.PersonEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    Person toDomainModel(PersonEntity entity);
    List<Person> toDomainModel(List<PersonEntity> entities);


    PersonEntity toEntity(Person domainModel);
}
