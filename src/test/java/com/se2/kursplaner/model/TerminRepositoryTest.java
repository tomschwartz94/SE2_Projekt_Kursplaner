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
        studiengang = new Studiengang("Studiengang", "st", 6);
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

    @Test
    public void findByModulId_Success(){
        assertThat(terminRepository.findByModulId(termin1.getModul().getId())).hasSize(2);
        assertThat(terminRepository.findByModulId(termin3.getModul().getId())).hasSize(1);
    }

    @Test
    public void findByModulId_Success_Empty(){
        assertThat(terminRepository.findByModulId(modul3.getId())).isEmpty();
    }
}

