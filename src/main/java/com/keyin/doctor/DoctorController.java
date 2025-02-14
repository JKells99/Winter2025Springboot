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
    public ResponseEntity<?> addPatientTODoctor(@PathVariable Long doctorId, @PathVariable Long patientID){
        Optional<Doctor> doctor = Optional.ofNullable(doctorService.findById(doctorId));
        Optional<Patient> patient = Optional.ofNullable(patientService.getPatientById(patientID));

        if(doctor.isPresent()){
            if(doctor.get().getPatientList().contains(patient.get())){
                return new ResponseEntity<>("Patient Already Exist In Patient List", HttpStatus.CONFLICT);
            } else{
                doctor.get().getPatientList().add(patient.orElse(null));
                doctorService.createDoctor(doctor.get());
            }
        }

        return new ResponseEntity<>("Added Patient To List,", HttpStatus.CREATED);
    }

    @GetMapping("/getAllPatientsForDoctorById/{doctorId}")
    public Iterable<Patient> getAllPatientsForDoctorById(@PathVariable Long doctorId){
        return doctorService.listPatientsByDoctorId(doctorId);
    }





}
