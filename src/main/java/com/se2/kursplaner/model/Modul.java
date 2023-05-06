package com.se2.kursplaner.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.Assert;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

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

    @OneToMany
    @Setter(AccessLevel.NONE)
    private List<Termin> termine;

    public Modul(String name, String kuerzel, Studiengang studiengang){
        this.name = name;
        this.kuerzel = kuerzel;
        this.studiengang = studiengang;
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
