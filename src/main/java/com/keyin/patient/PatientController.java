package com.keyin.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/getAllPatients")
    public Iterable<Patient> getAllPatients() {
        return patientService.getPatients();
    }

    @PostMapping("/patient")
    public Patient addPatient(@RequestBody Patient patient) {
        return patientService.createPatient(patient);
    }

    @DeleteMapping("/patient/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable int id) {
        patientService.deletePatientById(id);
        return ResponseEntity.ok().body("Patient deleted");

    }



}
