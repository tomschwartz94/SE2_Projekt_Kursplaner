package com.se2.kursplaner.services;

import com.se2.kursplaner.model.Termin;
import com.se2.kursplaner.model.TerminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TerminService {

    @Autowired
    TerminRepository terminRepository;


    public List<Termin> getTermineByModulId(Long moduleId) {
        return terminRepository.findByModulId(moduleId);
    }
}
