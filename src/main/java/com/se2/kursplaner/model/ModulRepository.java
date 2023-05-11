package com.se2.kursplaner.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModulRepository extends JpaRepository<Modul, Long> {
    Optional<Modul> findByStudiengang(Studiengang studiengang);
    Optional<Modul> findByName(String name);

    Optional<Modul> findByStudiengangAndSemester(Studiengang studiengang, Integer semester);
}
