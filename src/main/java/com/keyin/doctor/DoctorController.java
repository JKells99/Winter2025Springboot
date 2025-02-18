package com.keyin.doctor;

import com.keyin.patient.Patient;
import com.keyin.patient.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;
    @Autowired
    private PatientService patientService;

    @GetMapping("/getAllDoctors")
    public Iterable<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @PostMapping("/createADoctor")
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorService.createDoctor(doctor);
    }

    @DeleteMapping("/deleteDoctor/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable Long id) {
         doctorService.deleteDoctorById(id);
         return ResponseEntity.ok("Deleted Doctor with ID: " + id);

    }

    @PostMapping("/{doctorId}/add-patient/{patientID}")
    public ResponseEntity<String> addPatientToDoctor(@PathVariable Long doctorId, @PathVariable Long patientID) {
        Doctor doctor = doctorService.findById(doctorId);
        Patient patient = patientService.getPatientById(patientID);

        if (doctor == null || patient == null) {
            return new ResponseEntity<>("Doctor or patient not found", HttpStatus.NOT_FOUND);
        }

        if (doctor.getPatientList().contains(patient)) {
            return new ResponseEntity<>("Patient already exists in patient list", HttpStatus.CONFLICT);
        }

        doctor.getPatientList().add(patient);
        doctorService.createDoctor(doctor);

        return new ResponseEntity<>("Added patient to list", HttpStatus.CREATED);
    }

    @GetMapping("/getAllPatientsForDoctorById/{doctorId}")
    public Iterable<Patient> getAllPatientsForDoctorById(@PathVariable Long doctorId){
        return doctorService.listPatientsByDoctorId(doctorId);
    }





}
