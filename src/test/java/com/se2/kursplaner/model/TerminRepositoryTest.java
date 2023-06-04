package com.se2.kursplaner.model;

import com.se2.kursplaner.KursplanerApplication;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = KursplanerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ExtendWith(SpringExtension.class)
public class TerminRepositoryTest {

    @Autowired
    private TerminRepository terminRepository;
    @Autowired
    private ModulRepository modulRepository;
    @Autowired
    private StudiengangRepository studiengangRepository;

    private Termin termin1;
    private Termin termin2;
    private Termin termin3;

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

        termin1 = new Termin(new Date(2023, Calendar.SEPTEMBER, 8, 8, 30), new Date(2023, Calendar.SEPTEMBER, 8, 12, 30), modul1);
        terminRepository.save(termin1);
        termin2 = new Termin(new Date(2023, Calendar.SEPTEMBER, 10, 14, 30), new Date(2023, Calendar.SEPTEMBER, 10, 17, 0), modul1);
        terminRepository.save(termin2);
        termin3 = new Termin(new Date(2023, Calendar.SEPTEMBER, 10, 14, 30), new Date(2023, Calendar.SEPTEMBER, 10, 17, 0), modul2);
        terminRepository.save(termin3);
    }

    @AfterEach
    public void tearDown() {
        terminRepository.delete(termin1);
        terminRepository.delete(termin2);
        terminRepository.delete(termin3);
        modulRepository.delete(modul1);
        modulRepository.delete(modul2);
        modulRepository.delete(modul3);
        studiengangRepository.delete(studiengang);
    }

    @Test
    public void findByModul_Success(){
        assertThat(terminRepository.findByModul(termin1.getModul())).hasSize(2);
        assertThat(terminRepository.findByModul(termin3.getModul())).hasSize(1);
    }

    @Test
    public void findByModul_Success_Empty(){
        assertThat(terminRepository.findByModul(modul3)).isEmpty();
    }
}

