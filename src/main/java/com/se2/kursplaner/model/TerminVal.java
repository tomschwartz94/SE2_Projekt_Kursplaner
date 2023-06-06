package com.se2.kursplaner.model;

import java.util.ArrayList;
import java.util.List;

public class TerminVal {
    int error_anzahl = 0;
    List<TerminError> termin_error = new ArrayList<>();

    public int getError_anzahl() {
        return error_anzahl;
    }

    public List<TerminError> getTermin_error() {
        return termin_error;
    }

    public void setError_anzahl(int error_anzahl) {
        this.error_anzahl = error_anzahl;
    }

    
}
