package com.se2.kursplaner.web;

import com.se2.kursplaner.model.Modul;

import com.se2.kursplaner.model.TerminVal;
import com.se2.kursplaner.services.CollisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class KalenderController {

    @Autowired
    private CollisionService collisionService;

    // Endpoint to check for Termin collisions
    @PutMapping("/kalender/check")
    public ResponseEntity<TerminVal> checkTermine(@RequestBody List<Modul> module) {

        if (module.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(collisionService.checkTermine(module), HttpStatus.OK);
    }

    // Endpoint to export to .ics
    @PutMapping("/kalender/export")
    public String exportToICS(@RequestBody List<Modul> module) {
        // <TO-DO>: Add your implementation to export to .ics
        return null;
    }
}
