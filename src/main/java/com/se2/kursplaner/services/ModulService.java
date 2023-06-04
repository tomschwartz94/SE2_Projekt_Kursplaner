package com.se2.kursplaner.services;

import com.se2.kursplaner.model.Modul;
import com.se2.kursplaner.model.ModulRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModulService {

    private final ModulRepository modulRepository;

    @Autowired
    public ModulService(ModulRepository modulRepository) {
        this.modulRepository = modulRepository;
    }

    public List<Modul> getModuleForStudiengang(Long studiengangId) {
        // Logic to fetch modules for the given studiengangId.
        // Please adapt this line to fit your actual method to fetch data from the repository.
        return modulRepository.findByStudiengangId(studiengangId);
    }
}
