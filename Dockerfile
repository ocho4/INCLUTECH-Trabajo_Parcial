FROM maven:3.9.11-eclipse-temurin-17 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src

ENV LANG C.UTF-8
ENV LC_ALL C.UTF-8

RUN mvn clean package -DskipTests -Dfile.encoding=UTF-8

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
