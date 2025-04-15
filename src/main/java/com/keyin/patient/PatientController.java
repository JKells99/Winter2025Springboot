package com.keyin.patient;

import com.keyin.bloodpressure.BloodPressure;
import com.keyin.bloodpressure.BloodPressureService;
import com.keyin.insurance.Insurance;
import com.keyin.insurance.InsuranceRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/patient")
public class PatientController {
    private static final Logger log = LogManager.getLogger(PatientController.class);


    @Autowired
    private PatientService patientService;

    @Autowired
    private BloodPressureService bloodPressureService;

    @Autowired
    private InsuranceRepository insuranceRepository;

    @GetMapping("/getAllPatients")
    public Iterable<Patient> getAllPatients() {
        return patientService.getPatients();
    }

    @PostMapping("/createPatient")
    public Patient addPatient(@RequestBody Patient patient) {
        try {
            Insurance patientInsurance = insuranceRepository.findByInsuranceName(patient.insurance.getInsuranceName());
            if(patientInsurance == null) {
                insuranceRepository.save(patient.getInsurance());
                log.info("Insurance not found, creating new insurance");

            }

            return patientService.createPatient(patient);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/patient/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id) {
        try {
            patientService.deletePatientById(id);
            return ResponseEntity.ok().body("Patient deleted");
        } catch (Exception e) {
            log.error(e);
            throw new RuntimeException(e);
        }

    }

    @PutMapping("/updatePatient/{id}")
    public ResponseEntity<String> updatePatient(@PathVariable Long id ,@RequestBody Patient patient) {
        try {
            patientService.updatePatient(id,patient);
            return new ResponseEntity<>("Patient updated", HttpStatus.OK);
        } catch (Exception e) {
            log.error(e);
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/addBPReadingForPatient/{patientId}")
    public ResponseEntity<String> addBpReadingForPatient(@RequestBody BloodPressure bloodPressure, @PathVariable Long patientId) {
        try {
            Patient patient = patientService.getPatientById(patientId);
            patient.addBloodPressure(bloodPressure);
            bloodPressureService.addBloodPressureToSystem(bloodPressure);
            patientService.updatePatient(patientId,patient);
            return new ResponseEntity<>("Patient Bp Updated", HttpStatus.OK);
        } catch (Exception e) {
            log.error(e);
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/getAllBpReadingsForPatient/{patientId}")
    public List<BloodPressure> getAllReadingsForPatientById(@PathVariable Long patientId){
        try {
            Patient patient = patientService.getPatientById(patientId);
            return patient.getBloodPressures();
        } catch (Exception e) {
            log.error(e);
            throw new RuntimeException(e);
        }
    }



}
