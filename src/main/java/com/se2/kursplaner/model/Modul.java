package com.se2.kursplaner.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Modul {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 1, max = 100)
    private String name;

    @NotNull
    @Size(min = 1, max = 15)
    private String kuerzel;

    @ManyToOne
    private Studiengang studiengang;

    @NotNull
    private int semester;

    public Modul(String name, String kuerzel, Studiengang studiengang, int semester){
        this.name = name;
        this.kuerzel = kuerzel;
        this.semester = semester;
        this.studiengang = studiengang;
        this.semester = semester;
    }

}
