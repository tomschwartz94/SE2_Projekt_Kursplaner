package com.se2.kursplaner.model;

import lombok.AccessLevel;
import lombok.Data;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Termin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date start;

    @Temporal(TemporalType.TIMESTAMP)
    private Date ende;

    @ManyToOne
    private Modul modul;

    public Termin(Date start, Date ende, Modul modul){
        this.start = start;
        this.ende = ende;
        this.modul = modul;
    }
}
