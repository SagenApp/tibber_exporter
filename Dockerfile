# syntax=docker/dockerfile:1

FROM eclipse-temurin:18-jdk AS BUILD_IMAGE

WORKDIR /build

COPY .mvn/ .mvn
COPY mvnw pom.xml ./

RUN ./mvnw dependency:resolve

COPY src ./src

RUN ./mvnw clean package

FROM openjdk:18-alpine

WORKDIR /app

COPY --from=BUILD_IMAGE '/build/target/TibberExporter-1.0-SNAPSHOT.jar' .

EXPOSE 9456

ENTRYPOINT ["java", "-jar", "TibberExporter-1.0-SNAPSHOT.jar", "-p", "9456"]
