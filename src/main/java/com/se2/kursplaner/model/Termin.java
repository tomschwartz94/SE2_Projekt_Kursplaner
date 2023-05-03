package com.se2.kursplaner.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
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
