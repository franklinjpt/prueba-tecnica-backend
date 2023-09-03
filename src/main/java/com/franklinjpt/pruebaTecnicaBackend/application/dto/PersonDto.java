package com.franklinjpt.pruebaTecnicaBackend.application.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class PersonDto implements Serializable {
    private long id;
    private String documentNumber;
    @NotEmpty(message = "The first name is required")
    private String firstName;
    private String secondName;
    @NotEmpty(message = "The first last name is required")
    private String firstLastName;
    private String secondLastName;
    private Date birthDate;
}
