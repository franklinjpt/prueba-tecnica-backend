package com.franklinjpt.pruebaTecnicaBackend.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Person {
    private Long id;
    private String documentNumber;
    private String firstName;
    private String secondName;
    private String firstLastName;
    private String secondLastName;
    private Date birthDate;
}
