package com.se2.kursplaner.web;

import com.se2.kursplaner.model.Studiengang;
import com.se2.kursplaner.services.StudiengangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/studiengang")
public class StudiengangController {

    @Autowired
    StudiengangService studiengangService;


    @GetMapping
    public ResponseEntity<List<Studiengang>> getAllStudiengange() {
        List<Studiengang> studiengange = studiengangService.getAllStudiengange();

        if (studiengange.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(studiengange, HttpStatus.OK);
    }
}
