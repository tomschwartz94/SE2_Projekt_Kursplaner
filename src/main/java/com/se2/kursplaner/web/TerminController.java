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
    @PutMapping("/{id}")
    public Termin updateTermin(@RequestBody Termin newTermin, @PathVariable Long id) {
        return terminRepository.findById(id)
                .map(termin -> {
                    termin.setStart(newTermin.getStart());
                    termin.setEnde(newTermin.getEnde());
                    return terminRepository.save(termin);
                })
                .orElseGet(() -> {
                    newTermin.setId(id);
                    return terminRepository.save(newTermin);
                });
    }

    @DeleteMapping("/{id}")
    public void deleteTermin(@PathVariable Long id) {
        terminRepository.deleteById(id);
    }
}
