FROM maven:3.8.5-openjdk-17-slim
LABEL authors="kursplaner"
COPY . .
EXPOSE 8080
ENTRYPOINT ["mvn", "spring-boot:run", "-Pprod"]



