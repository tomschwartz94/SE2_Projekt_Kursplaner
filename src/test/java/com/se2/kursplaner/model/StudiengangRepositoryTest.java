package com.se2.kursplaner.model;

import com.se2.kursplaner.KursplanerApplication;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = KursplanerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ExtendWith(SpringExtension.class)
public class StudiengangRepositoryTest {

    @Autowired
    private StudiengangRepository studiengangRepository;

    private Studiengang studiengang1;
    private Studiengang studiengang2;

    @BeforeEach
    public void setUp(){
        studiengang1 = new Studiengang("Studiengang_1", "st1", 6);
        studiengangRepository.save(studiengang1);
        studiengang2 = new Studiengang("Studiengang_2", "st2", 6);
        studiengangRepository.save(studiengang2);
    }

    @AfterEach
    public void tearDown(){
        studiengangRepository.delete(studiengang1);
        studiengangRepository.delete(studiengang2);
    }

    @Test
    public void findByName_Success(){
        assertThat(studiengangRepository.findByName(studiengang1.getName())).isNotNull();
        assertThat(studiengangRepository.findByName(studiengang2.getName())).isNotNull();
    }

    @Test
    public void findByName_Success_Empty(){
        String name = "Doesn't exist";
        assertThat(studiengangRepository.findByName(name)).isNull();
    }

    @Test
    public void findAll_Success(){
        assertThat(studiengangRepository.findAll()).hasSize(3);
    }
}
