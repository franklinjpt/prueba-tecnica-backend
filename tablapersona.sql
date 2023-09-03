CREATE TABLE personas (
id serial PRIMARY KEY,
numero_documento VARCHAR(25) UNIQUE NOT NULL,
primer_nombre VARCHAR(45) NOT NULL,
segundo_nombre VARCHAR(45),
primer_apellido VARCHAR(45) NOT NULL,
segundo_apellido VARCHAR(45),
fecha_nacimiento DATE
);

INSERT INTO personas (numero_documento,primer_nombre,primer_apellido) VALUES ('111','Fj','Pt');
