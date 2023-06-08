package com.se2.kursplaner.services;

import com.se2.kursplaner.KursplanerApplication;
import com.se2.kursplaner.model.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Calendar;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = KursplanerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class CollisionServiceTest {

    @Autowired
    private TerminRepository terminRepository;
    @Autowired
    private ModulRepository modulRepository;
    @Autowired
    private StudiengangRepository studiengangRepository;
    @Autowired
    private CollisionService collisionService;

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
    public void checkTermine_Success_No_Collision(){
        TerminVal terminVal = collisionService.checkTermine(List.of(modul1, modul3));
        assertThat(terminVal.getError_anzahl()).isEqualTo(0);
        assertThat(terminVal.getTermin_error()).hasSize(0);
    }

    @Test
    public void checkTermine_Success_With_Collision(){
        TerminVal terminVal = collisionService.checkTermine(List.of(modul1, modul2, modul3));
        assertThat(terminVal.getError_anzahl()).isEqualTo(1);
        assertThat(terminVal.getTermin_error()).hasSize(1);
    }
}
