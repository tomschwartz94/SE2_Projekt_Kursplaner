package com.se2.kursplaner.model;

import lombok.AccessLevel;
import lombok.Data;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
