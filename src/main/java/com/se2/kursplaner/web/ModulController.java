package com.se2.kursplaner.web;

import com.se2.kursplaner.model.Modul;
import com.se2.kursplaner.model.Termin;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ModulController {



    // Endpoint to get all Module for a Studiengang
    @GetMapping("/modul/{studiengangId}")
    public List<Modul> getModuleByStudiengangId(@PathVariable Long studiengangId) {
        // <TO-DO>: Add your implementation to return all Module for a Studiengang
        return null;
    }

    // Endpoint to get all Termine for a Modul
    @GetMapping("/modul/termin/{moduleId}")
    public List<Termin> getTermineByModulId(@PathVariable Long moduleId) {
        // <TO-DO>: Add your implementation to return all Termine for a Modul
        return null;
    }


}
