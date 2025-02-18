package com.keyin.patient;

import com.keyin.bloodpressure.BloodPressure;
import com.keyin.bloodpressure.BloodPressureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private BloodPressureService bloodPressureService;

    @GetMapping("/getAllPatients")
    public Iterable<Patient> getAllPatients() {
        return patientService.getPatients();
    }

    @PostMapping("/createPatient")
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

    @PostMapping("/addBPReadingForPatient/{patientId}")
    public ResponseEntity<String> addBpReadingForPatient(@RequestBody BloodPressure bloodPressure, @PathVariable Long patientId) {
        Patient patient = patientService.getPatientById(patientId);
        patient.addBloodPressure(bloodPressure);
        bloodPressureService.addBloodPressureToSystem(bloodPressure);
        patientService.updatePatient(patientId,patient);
        return new ResponseEntity<>("Patient Bp Updated", HttpStatus.OK);
    }

    @GetMapping("/getAllBpReadingsForPatient/{patientId}")
    public List<BloodPressure> getAllReadingsForPatientById(@PathVariable Long patientId){
        Patient patient = patientService.getPatientById(patientId);

        return patient.getBloodPressures();
    }



}
