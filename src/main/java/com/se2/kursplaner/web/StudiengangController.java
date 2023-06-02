package com.se2.kursplaner.web;


import com.se2.kursplaner.model.Studiengang;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudiengangController {

    // Endpoint to get all Studiengänge
    @GetMapping("/studiengang")
    public List<Studiengang> getAllStudiengange() {
        // <TO-DO>: Add your implementation to return all Studiengänge
        return null;
    }


}
