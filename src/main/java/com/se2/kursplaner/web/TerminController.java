package com.se2.kursplaner.web;

import com.se2.kursplaner.model.Termin;
import com.se2.kursplaner.model.TerminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/termin")
public class TerminController {

    @Autowired
    private TerminRepository terminRepository;

    @GetMapping
    public List<Termin> getAllTermin() {
        return terminRepository.findAll();
    }

    @PostMapping
    public Termin createTermin(@RequestBody Termin termin) {
        return terminRepository.save(termin);
    }
}
