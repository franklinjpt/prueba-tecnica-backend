# Prueba Tecnica Backend Trainee

Aplicación para gestionar el CRUD de personas. Esta aplicación ha sido desarrollada utilizando Java 17, Spring Boot, PostgreSQL, y Docker. Además, se ha adoptado la arquitectura de diseño guiado por el dominio (DDD) para su estructuración.

## Requisitos

Para poder ejecutar la aplicación, es necesario tener instalado Docker y Docker Compose. Para ello, se puede seguir la guía de instalación de Docker para [Windows](https://docs.docker.com/docker-for-windows/install/), [Mac](https://docs.docker.com/docker-for-mac/install/) o [Linux](https://docs.docker.com/engine/install/).

## Ejecución

Para ejecutar la aplicación, es necesario seguir los siguientes pasos:

1. Clonar el repositorio
2. Antes de ejecutar la aplicación por primera vez se debe compilar el proyecto con el siguiente comando:
```bash
./gradlew build -x test
```
3. Ejecutar el siguiente comando para construir y levantar los contenedores:
```bash
docker-compose up --build
```

Una vez iniciada, la aplicación estará disponible en la siguiente URL: http://localhost:8080

## Documentación

La documentación de la API se encuentra disponible en la siguiente URL: http://localhost:8080/v1/api/swagger-ui/index.html gracias a OpenAPI y Swagger. Aquí se encuentran los detalles de los endpoints, sus parametros y respuestas.

## Arquitectura y diseño

- <b>Diseño guiado por el dominio (DDD):</b> La aplicación está estructurada siguiendo los principios de DDD, permitiendo una separación clara de responsabilidades y una fácil evolución de la lógica de negocio.

## Autor

- Franklin Jesus Pineda Trujillo - [@franklinjpt](https://www.github.com/franklinjpt)