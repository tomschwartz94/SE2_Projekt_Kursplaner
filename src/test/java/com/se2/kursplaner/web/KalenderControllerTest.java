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
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = KursplanerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class KalenderControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TerminRepository terminRepository;
    @Autowired
    private ModulRepository modulRepository;
    @Autowired
    private StudiengangRepository studiengangRepository;

    private Termin termin1;
    private Termin termin2;
    private Termin termin3;
    private Termin termin4;

    private Modul modul1;
    private Modul modul2;
    private Modul modul3;
    private Studiengang studiengang;

    @BeforeEach
    public void setUp(){
        studiengang = new Studiengang("Studiengang", "st");
        studiengangRepository.save(studiengang);

        modul1 = new Modul("Modul1", "m1", studiengang, 3);
        modulRepository.save(modul1);
        modul2 = new Modul("Modul2", "m2", studiengang, 2);
        modulRepository.save(modul2);
        modul3 = new Modul("Modul3", "m3", studiengang, 2);
        modulRepository.save(modul3);

        Calendar start = Calendar.getInstance();
        start.set(2023, Calendar.SEPTEMBER, 8, 8, 30);
        Calendar end = Calendar.getInstance();
        end.set(2023, Calendar.SEPTEMBER, 8, 12, 30);
        termin1 = new Termin(start.getTime(), end.getTime(), modul1);
        terminRepository.save(termin1);

        start.set(2023, Calendar.SEPTEMBER, 10, 14, 30);
        end.set(2023, Calendar.SEPTEMBER, 10, 17, 0);
        termin2 = new Termin(start.getTime(), end.getTime(), modul1);
        terminRepository.save(termin2);

        start.set(2023, Calendar.SEPTEMBER, 10, 14, 30);
        end.set(2023, Calendar.SEPTEMBER, 10, 17, 0);
        termin3 = new Termin(start.getTime(), end.getTime(), modul2);
        terminRepository.save(termin3);

        start.set(2023, Calendar.SEPTEMBER, 5, 9, 30);
        end.set(2023, Calendar.SEPTEMBER, 5, 13, 0);
        termin4 = new Termin(start.getTime(), end.getTime(), modul3);
        terminRepository.save(termin4);

        RestAssured.port = port;
        RestAssured.basePath = "";
    }

    @AfterEach
    public void tearDown() {
        terminRepository.delete(termin1);
        terminRepository.delete(termin2);
        terminRepository.delete(termin3);
        terminRepository.delete(termin4);
        modulRepository.delete(modul1);
        modulRepository.delete(modul2);
        modulRepository.delete(modul3);
        studiengangRepository.delete(studiengang);
    }

    @Test
    public void checkTermine_Modul_Not_Given(){
        given().
                contentType("application/json").

        when().
                put("/api/kalender/check").

        then().
                statusCode(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void checkTermine_Success_No_Collision(){
        given().
                contentType("application/json").
                body(List.of(modul1, modul3)).

        when().
                put("/api/kalender/check").

        then().
                statusCode(HttpStatus.OK.value()).
                body("error_anzahl", equalTo(0));
    }

    @Test
    public void checkTermine_Success_With_Collision(){
        given().
                contentType("application/json").
                body(List.of(modul1, modul2, modul3)).

        when().
                put("/api/kalender/check").

        then().
                statusCode(HttpStatus.OK.value()).
                body("error_anzahl", equalTo(1));
    }

}
