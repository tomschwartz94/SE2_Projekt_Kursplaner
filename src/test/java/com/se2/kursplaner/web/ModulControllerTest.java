package com.se2.kursplaner.web;

import com.se2.kursplaner.KursplanerApplication;
import com.se2.kursplaner.model.*;
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

import java.util.Calendar;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = KursplanerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ModulControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private StudiengangRepository studiengangRepository;

    @Autowired
    private ModulRepository modulRepository;

    @Autowired
    private TerminRepository terminRepository;

    private Studiengang studiengang;
    private Modul modul1;
    private Modul modul2;
    private Termin termin1;
    private Termin termin2;

    @BeforeEach
    void setUp(){
        studiengang = new Studiengang("Studiengang1", "st1");
        studiengangRepository.save(studiengang);
        modul1 = new Modul("Modul1", "m1", studiengang, 1);
        modulRepository.save(modul1);
        modul2 = new Modul("Modul2", "m2", studiengang, 2);
        modulRepository.save(modul2);
        Calendar start = Calendar.getInstance();
        start.set(2022, Calendar.DECEMBER, 3, 15,30);
        Calendar end = Calendar.getInstance();
        end.set(2022, Calendar.DECEMBER, 3, 18,30);
        termin1 = new Termin(start.getTime(), end.getTime(), modul1);
        terminRepository.save(termin1);
        start.set(2022, Calendar.DECEMBER, 10, 15,30);
        end.set(2022, Calendar.DECEMBER, 10, 18,30);
        termin2 = new Termin(start.getTime(), end.getTime(), modul1);
        terminRepository.save(termin2);


        RestAssured.port = port;
        RestAssured.basePath = "";
    }

    @AfterEach
    void tearDown(){
        terminRepository.delete(termin1);
        terminRepository.delete(termin2);
        modulRepository.delete(modul1);
        modulRepository.delete(modul2);
        studiengangRepository.delete(studiengang);
    }

    @Test
    public void getModuleByStudiengangId_Success(){
        given().

        when().
                get("/api/modul/{studiengangId}", studiengang.getId()).

        then().
                statusCode(HttpStatus.OK.value()).
                body("name", hasItems("Modul1", "Modul2"));
    }

    @Test
    public void getModuleByStudiengangId_Failed(){
        given().

        when().
                get("/api/modul/{studiengangId}", Integer.MAX_VALUE).

        then().
                statusCode(HttpStatus.NO_CONTENT.value());
    }

    @Test
    public void getTermineByModulId_Success(){
        given().

        when().
                get("/api/modul/termin/{moduleId}", modul1.getId()).

        then().
                statusCode(HttpStatus.OK.value()).
                body("size()", equalTo(2));
    }
}
