package com.se2.kursplaner.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Studiengang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 100)
    private String name;

    @NotNull
    @Size(min = 1, max = 5)
    private String kuerzel;

//    @OneToMany(cascade = CascadeType.ALL)
//    private Modul modul;

    public Studiengang(String name, String kuerzel){
        this.name = name;
        this.kuerzel = kuerzel;
    }

    public String getName(){
        return name;
    }

    public String getKuerzel(){
        return kuerzel;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setKuerzel(String kuerzel){
        this.kuerzel = kuerzel;
    }
}
