package com.franklinjpt.pruebaTecnicaBackend.infrastructure.persistence.repository;

import com.franklinjpt.pruebaTecnicaBackend.infrastructure.persistence.entity.PersonEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CrudPersonRepository extends CrudRepository<PersonEntity, Long> {
    Optional<PersonEntity> findByDocumentNumber(String documentNumber);
}
