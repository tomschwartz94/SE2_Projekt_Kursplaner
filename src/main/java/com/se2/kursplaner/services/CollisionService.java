package com.se2.kursplaner.services;

import com.se2.kursplaner.model.Modul;
import com.se2.kursplaner.model.Termin;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollisionService {

    public List<Termin> checkTermine(List<Modul> module) {
        List<Termin> overlappingTermines = new ArrayList<>();
        List<Termin> allTermine = new ArrayList<>();

        for(Modul m : module) {
            allTermine.addAll(m.getTermine());
        }

        for(int i = 0; i < allTermine.size(); i++) {
            for(int j = i + 1; j < allTermine.size(); j++) {
                if(checkOverlap(allTermine.get(i), allTermine.get(j))) {
                    overlappingTermines.add(allTermine.get(i));
                    overlappingTermines.add(allTermine.get(j));
                }
            }
        }

        return overlappingTermines;
    }

    private boolean checkOverlap(Termin t1, Termin t2) {
        return t1.getStart().isBefore(t2.getEnde()) && t1.getEnde().isAfter(t2.getStart());
    }

}
