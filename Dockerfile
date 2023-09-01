FROM eclipse-temurin:17.0.8.1_1-jre-alpine

COPY build/libs/pruebaTecnicaBackend-0.0.1-SNAPSHOT.jar pruebaTecnicaBackend-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/pruebaTecnicaBackend-0.0.1-SNAPSHOT.jar"]
