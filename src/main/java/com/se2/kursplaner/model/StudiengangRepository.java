package com.se2.kursplaner.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudiengangRepository extends JpaRepository<Studiengang, Long> {
    List<Studiengang> findByName(String name);

    List<Studiengang> findAll();

}
