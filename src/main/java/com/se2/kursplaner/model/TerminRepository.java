package com.se2.kursplaner.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TerminRepository extends JpaRepository<Termin, Long> {
    Optional<Termin> findByModul(Modul modul);
    
}
