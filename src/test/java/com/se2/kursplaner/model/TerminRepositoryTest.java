package com.se2.kursplaner.model;

import com.se2.kursplaner.KursplanerApplication;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

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

        modul1 = new Modul("Modul1", "m1", 3, studiengang);
        modulRepository.save(modul1);
        modul2 = new Modul("Modul2", "m2", 2, studiengang);
        modulRepository.save(modul2);
        modul3 = new Modul("Modul3", "m3", 2, studiengang);
        modulRepository.save(modul3);

        termin1 = new Termin(LocalDateTime.of(2023, 8, 8, 8, 30), LocalDateTime.of(2023, 8, 8, 12, 30), modul1);
        terminRepository.save(termin1);
        termin2 = new Termin(LocalDateTime.of(2023, 8, 10, 14, 30), LocalDateTime.of(2023, 8, 10, 17, 0), modul1);
        terminRepository.save(termin2);
        termin3 = new Termin(LocalDateTime.of(2023, 8, 10, 14, 30), LocalDateTime.of(2023, 8, 10, 17, 0), modul2);
        terminRepository.save(termin3);
    }

    @AfterEach
    public void tearDown() {
        terminRepository.deleteAll();
        modulRepository.deleteAll();
        studiengangRepository.deleteAll();
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

