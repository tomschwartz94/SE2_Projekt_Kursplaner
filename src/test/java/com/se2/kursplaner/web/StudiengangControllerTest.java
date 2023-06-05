package com.se2.kursplaner.web;

import com.se2.kursplaner.KursplanerApplication;
import com.se2.kursplaner.model.Studiengang;
import com.se2.kursplaner.model.StudiengangRepository;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = KursplanerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudiengangControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private StudiengangRepository studiengangRepository;

    private Studiengang studiengang;

    @BeforeEach
    void setUp(){
        studiengang = new Studiengang("Studiengang1", "st1");
        studiengangRepository.save(studiengang);

        RestAssured.port = port;
        RestAssured.basePath = "";
    }

    @AfterEach
    void tearDown(){
        studiengangRepository.delete(studiengang);
    }

    @Test
    public void getAllStudiengange_Success(){
        given().

        when().
                get("/api/studiengang").

        then().
                statusCode(HttpStatus.OK.value()).
                body("name", hasItems("Studiengang1"));
    }

}
