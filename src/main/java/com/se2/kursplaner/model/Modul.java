package com.se2.kursplaner.model;

import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Modul {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 100)
    private String name;

    @NotNull
    @Size(min = 1, max = 5)
    private String kuerzel;

    @ManyToOne
    private Studiengang studiengang;

    @OneToMany
    private List<Termin> termine;

    public Modul(String name, String kuerzel, Studiengang studiengang){
        this.name = name;
        this.kuerzel = kuerzel;
        this.studiengang = studiengang;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKuerzel() {
        return kuerzel;
    }

    public void setKuerzel(String kuerzel) {
        this.kuerzel = kuerzel;
    }

    public Studiengang getStudiengang() {
        return studiengang;
    }

    public void setStudiengang(Studiengang studiengang) {
        this.studiengang = studiengang;
    }

    public List<Termin> getTermine() {
        return termine;
    }

    public void setTermine(List<Termin> termine) {
        this.termine = termine;
    }

    public boolean addTermin(Termin termin){
        // check preconditions
        Assert.notNull(termin, "Parameter 'termin' can't be null!");

        // check if module already has this termin
        boolean moduleAlreadyHasTermin = termine.stream()
                .anyMatch(t -> t.getId().equals(termin.getId()));

        if (!moduleAlreadyHasTermin) {
            termine.add(termin);
            return true;
        }

        return false;
    }
}
