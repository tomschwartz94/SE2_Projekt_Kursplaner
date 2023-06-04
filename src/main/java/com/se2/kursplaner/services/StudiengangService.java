package com.se2.kursplaner.services;

import com.se2.kursplaner.model.Studiengang;
import com.se2.kursplaner.model.StudiengangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudiengangService {

    @Autowired
    private StudiengangRepository studiengangRepository;

    public List<Studiengang> getAllStudiengange() {
        return studiengangRepository.findAll();
    }

    //... other methods will follow

}
