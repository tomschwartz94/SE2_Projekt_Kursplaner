package com.se2.kursplaner.controller;

import com.se2.kursplaner.model.Studiengang;
import com.se2.kursplaner.model.StudiengangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/studiengang")
public class StudiengangController {

    @Autowired
    private StudiengangRepository studiengangRepository;

    @GetMapping
    public List<Studiengang> getAllStudiengang() {
        return studiengangRepository.findAll();
    }

    @PostMapping
    public Studiengang createStudiengang(@RequestBody Studiengang studiengang) {
        return studiengangRepository.save(studiengang);
    }
}
