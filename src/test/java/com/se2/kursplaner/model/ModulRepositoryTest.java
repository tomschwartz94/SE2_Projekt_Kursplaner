package com.se2.kursplaner.model;

import com.se2.kursplaner.KursplanerApplication;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = KursplanerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ExtendWith(SpringExtension.class)
public class ModulRepositoryTest {

    @Autowired
    private ModulRepository modulRepository;
    @Autowired
    private StudiengangRepository studiengangRepository;

    private Modul modul1;
    private Modul modul2;
    private Modul modul3;

    private Studiengang studiengang1;
    private Studiengang studiengang2;
    private Studiengang studiengang3;

    @BeforeEach
    public void setUp(){
        studiengang1 = new Studiengang("Studiengang1", "st1");
        studiengangRepository.save(studiengang1);
        studiengang2 = new Studiengang("Studiengang2", "st2");
        studiengangRepository.save(studiengang2);
        studiengang3 = new Studiengang("Studiengang3", "st3");
        studiengangRepository.save(studiengang3);

        modul1 = new Modul("Modul1", "m1",  studiengang1, 2);
        modulRepository.save(modul1);
        modul2 = new Modul("Modul2", "m2", studiengang2, 3);
        modulRepository.save(modul2);
        modul3 = new Modul("Modul3", "m3", studiengang2, 3);
        modulRepository.save(modul3);
    }

    @AfterEach
    public void tearDown(){
        modulRepository.deleteAll();
        studiengangRepository.deleteAll();
    }

    @Test
    public void findByStudiengang_Success(){
        assertThat(modulRepository.findByStudiengang(modul2.getStudiengang())).hasSize(2);
        assertThat(modulRepository.findByStudiengang(modul1.getStudiengang())).hasSize(1);
    }

    @Test
    public void findByStudiengang_Success_Empty(){
        assertThat(modulRepository.findByStudiengang(studiengang3)).isEmpty();
    }

    @Test
    public void findByName_Success(){
        String modul1_name = modul1.getName();
        String modul2_name = modul2.getName();
        String modul3_name = modul3.getName();

        assertThat(modulRepository.findByName(modul1_name)).isNotNull();
        assertThat(modulRepository.findByName(modul2_name)).isNotNull();
        assertThat(modulRepository.findByName(modul3_name)).isNotNull();

    }

    @Test
    public void findByName_Sucess_Empty(){
        String modul_name = "Nothing";

        assertThat(modulRepository.findByName(modul_name)).isNull();
    }

    @Test
    public void findByStudiengangAndSemester_Success(){
        Studiengang studiengang_modul3 = modul3.getStudiengang();
        Integer semester = modul2.getSemester();

        assertThat(modulRepository.findByStudiengangAndSemester(studiengang_modul3, semester)).hasSize(2);
    }

    @Test
    public void findByStudiengangAndSemester_Success_Empty(){
        Studiengang studiengang_modul3 = modul3.getStudiengang();
        Integer semester = modul2.getSemester();

        assertThat(modulRepository.findByStudiengangAndSemester(studiengang3, semester)).isEmpty();
        assertThat(modulRepository.findByStudiengangAndSemester(studiengang_modul3, 1)).isEmpty();
    }


}
