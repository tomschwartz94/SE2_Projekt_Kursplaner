package com.se2.kursplaner.web;

import com.se2.kursplaner.model.Modul;
import com.se2.kursplaner.model.Termin;


import com.se2.kursplaner.services.ModulService;
import com.se2.kursplaner.services.TerminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/modul")
@RestController
public class ModulController {

    @Autowired
    private ModulService modulService;

    @Autowired
    private TerminService terminService;

    // Endpoint to get all Module for a Studiengang
    @GetMapping("/{studiengangId}")
    public ResponseEntity<List<Modul>> getModuleByStudiengangId(@PathVariable Long studiengangId) {
        List<Modul> module = modulService.getModuleForStudiengang(studiengangId);

        if (module.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(module, HttpStatus.OK);
    }


    // Endpoint to get all Termine for a Modul
    @GetMapping("/termin/{moduleId}")
    public List<Termin> getTermineByModulId(@PathVariable Long moduleId) {
        return terminService.getTermineByModulId(moduleId);
    }


}
