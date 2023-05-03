package com.se2.kursplaner.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudiengangRepository extends JpaRepository<Studiengang, Long> {
    Optional<Studiengang> findByName(String name);

    List<Studiengang> findAll();

//    @Query(value = "SELECT s FROM Studiengang s")
//    Optional<Studiengang> findAllStudiengang();
}
