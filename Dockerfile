FROM maven:3.8.5-openjdk-17-slim
LABEL authors="kursplaner"
COPY . .
EXPOSE 8080
PUBLISH 8080
RUN mvn -f pom.xml clean package -Pprod
ENTRYPOINT ["mvn", "spring-boot:run", "-Pprod"]



