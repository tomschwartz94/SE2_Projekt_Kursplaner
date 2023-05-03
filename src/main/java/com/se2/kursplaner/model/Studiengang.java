package com.se2.kursplaner.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
public class Studiengang {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 1, max = 100)
    private String name;

    @NotNull
    @Size(min = 1, max = 5)
    private String kuerzel;

//    @OneToMany(cascade = CascadeType.ALL)
//    private List<Modul> module;

    public Studiengang(String name, String kuerzel){
        this.name = name;
        this.kuerzel = kuerzel;
    }
}
