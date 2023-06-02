package com.se2.kursplaner.web;

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
        System.out.println("Ich bin in getMethode");
        return studiengangRepository.findAll();
    }

    @GetMapping(path = "/create")
    public Studiengang createStudiengang(@RequestParam String name, @RequestParam String kuerzel) {
        Studiengang newStudiengang = new Studiengang(name, kuerzel);
        return studiengangRepository.save(newStudiengang);
    }

//    @PostMapping
//    public Studiengang createStudiengang(@RequestBody Studiengang studiengang) {
//        System.out.println(studiengang.getName() +" " + studiengang.getKuerzel());
//        return studiengangRepository.save(studiengang);
//    }
    @PutMapping("/{id}")
    public Studiengang updateStudiengang(@RequestBody Studiengang newStudiengang, @PathVariable Long id) {
        return studiengangRepository.findById(id)
                .map(studiengang -> {
                    studiengang.setName(newStudiengang.getName());
                    studiengang.setKuerzel(newStudiengang.getKuerzel());
                    return studiengangRepository.save(studiengang);
                })
                .orElseGet(() -> {
                    newStudiengang.setId(id);
                    return studiengangRepository.save(newStudiengang);
                });
    }

    @DeleteMapping("/{id}")
    public void deleteStudiengang(@PathVariable Long id) {
        studiengangRepository.deleteById(id);
    }
}
