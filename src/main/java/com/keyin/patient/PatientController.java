package com.keyin.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/patient")
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
    public ResponseEntity<String> deletePatient(@PathVariable Long id) {
        patientService.deletePatientById(id);
        return ResponseEntity.ok().body("Patient deleted");

    }

    @PutMapping("/updatePatient/{id}")
    public ResponseEntity<String> updatePatient(@PathVariable Long id ,@RequestBody Patient patient) {
        patientService.updatePatient(id,patient);
        return new ResponseEntity<>("Patient updated", HttpStatus.OK);
    }



}
