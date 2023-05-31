package com.se2.kursplaner.model;

import lombok.AccessLevel;
import lombok.Data;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Termin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime start;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime ende;

    @ManyToOne
    private Modul modul;

    public Termin(LocalDateTime start, LocalDateTime ende, Modul modul){
        this.start = start;
        this.ende = ende;
        this.modul = modul;
    }
}
