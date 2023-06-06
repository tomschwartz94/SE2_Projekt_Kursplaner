package com.se2.kursplaner.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TerminRepository extends JpaRepository<Termin, Long> {
    List<Termin> findByModul(Modul modul);

    List<Termin> findByModulId(Long moduleId);
}
