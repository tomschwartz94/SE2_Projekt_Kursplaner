package com.se2.kursplaner.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudiengangRepository extends JpaRepository<Studiengang, Long> {
    Studiengang findByName(String name);

    List<Studiengang> findAll();

//    @Query(value = "SELECT s FROM Studiengang s")
//    Optional<Studiengang> findAllStudiengang();
}
