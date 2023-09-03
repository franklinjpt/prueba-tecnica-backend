package com.franklinjpt.pruebaTecnicaBackend.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "personas")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_documento")
    private String documentNumber;

    @Column(name = "primer_nombre")
    private String firstName;

    @Column(name = "segundo_nombre")
    private String secondName;

    @Column(name = "primer_apellido")
    private String firstLastName;

    @Column(name = "segundo_apellido")
    private String secondLastName;

    @Column(name = "fecha_nacimiento")
    private String birthDate;
}
