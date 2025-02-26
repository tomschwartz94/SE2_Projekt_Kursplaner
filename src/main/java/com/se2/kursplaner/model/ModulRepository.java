package com.se2.kursplaner.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModulRepository extends JpaRepository<Modul, Long> {
    List<Modul> findByStudiengang(Studiengang studiengang);
    Modul findByName(String name);
    Modul findByNameAndStudiengang(String name, Studiengang studiengang);
    List<Modul> findByStudiengangAndSemester(Studiengang studiengang, Integer semester);

    List<Modul> findByStudiengangId(Long studiengangId);
}
