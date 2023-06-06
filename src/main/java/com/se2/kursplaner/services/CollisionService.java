package com.se2.kursplaner.services;

import com.se2.kursplaner.model.Modul;
import com.se2.kursplaner.model.Termin;
import com.se2.kursplaner.model.TerminError;
import com.se2.kursplaner.model.TerminRepository;
import com.se2.kursplaner.model.TerminVal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CollisionService {

    @Autowired
    TerminRepository terminRepository;

    public TerminVal checkTermine(List<Modul> module) {

        Map<Modul, List<Termin>> allTermine = new HashMap<>();

        TerminVal terminVal = new TerminVal();

        for(Modul m : module) {
            allTermine.put(m, terminRepository.findByModul(m));
        }

        List<List<Termin>> allValues = (List<List<Termin>>) allTermine.values();

        for(int i = 0; i < allTermine.size(); i++) {
            for(int j = i + 1; j < allTermine.size(); j++) {

                for (Termin t1:allValues.get(i)){
                    for (Termin t2:allValues.get(j)){
                        if(checkOverlap(t1, t2)) {
                            terminVal.getTermin_error().add(new TerminError(t1, t2));
                            terminVal.setError_anzahl(terminVal.getError_anzahl()+1);

                        }
                    }
                }

            }
        }

        return terminVal;
    }

    private boolean checkOverlap(Termin t1, Termin t2) {
        return t1.getStart().before(t2.getEnde()) && t1.getEnde().after(t2.getStart());
    }

}
