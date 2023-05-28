package com.se2.kursplaner.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/kalender")
public class KalenderController {


    @GetMapping()
    public List<Lecturer> getLecturers() {
        return lecturerRepository.findAll(); // als json
    }

    @GetMapping(value = "/{id:[\\d]+}")
    public Lecturer getLecturer(@PathVariable("id") Long lecturerId) throws LecturerNotFoundException {
        return lecturerRepository
                .findById(lecturerId)
                .orElseThrow( () -> new LecturerNotFoundException(lecturerId));
    }

    
}
