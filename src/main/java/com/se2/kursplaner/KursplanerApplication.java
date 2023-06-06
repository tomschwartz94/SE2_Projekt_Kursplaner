package com.se2.kursplaner;

import com.se2.kursplaner.model.Studiengang;
import com.se2.kursplaner.model.StudiengangRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class KursplanerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KursplanerApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(StudiengangRepository studiengangRepository) {
		return (args) -> {
			Studiengang studiengang = new Studiengang("Math", "MA");
			studiengangRepository.save(studiengang);






		};
	}
}
