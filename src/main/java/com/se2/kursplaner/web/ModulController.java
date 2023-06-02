package com.se2.kursplaner.controller;

import com.se2.kursplaner.model.Modul;
import com.se2.kursplaner.model.ModulRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modul")
public class ModulController {

    @Autowired
    private ModulRepository modulRepository;

    @GetMapping
    public List<Modul> getAllModul() {
        return modulRepository.findAll();
    }

    @PostMapping
    public Modul createModul(@RequestBody Modul modul) {
        return modulRepository.save(modul);
    }
    @PutMapping("/{id}")
    public Modul updateModul(@RequestBody Modul newModul, @PathVariable Long id) {
        return modulRepository.findById(id)
                .map(modul -> {
                    modul.setName(newModul.getName());
                    modul.setKuerzel(newModul.getKuerzel());
                    modul.setSemester(newModul.getSemester());
                    return modulRepository.save(modul);
                })
                .orElseGet(() -> {
                    newModul.setId(id);
                    return modulRepository.save(newModul);
                });
    }

    @DeleteMapping("/{id}")
    public void deleteModul(@PathVariable Long id) {
        modulRepository.deleteById(id);
    }
}
