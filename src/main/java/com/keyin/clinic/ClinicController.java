package com.keyin.clinic;

import com.keyin.doctor.Doctor;
import com.keyin.doctor.DoctorService;
import com.keyin.patient.Patient;
import com.keyin.patient.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/clinic")
public class ClinicController {

    @Autowired
    ClinicService clinicService;

    @Autowired
    PatientService patientService;

    @Autowired
    DoctorService doctorService;

    @PostMapping("/addNewClinic")
    public ResponseEntity<String> createNewClinic(@RequestBody Clinic clinic){
         clinicService.createANewClinic(clinic);
         return new ResponseEntity<>("Clinic Created", HttpStatus.CREATED);

    }

    @GetMapping("/getAllClinics")
    public Iterable<Clinic> getAllClinics(){
        return clinicService.getListOfClinics();
    }

    @PostMapping("/{clinicId}/add-patient/{patientID}")
    public ResponseEntity<String> addPatientToClinic(@PathVariable Long clinicId, @PathVariable Long patientID) throws Exception {
        Clinic clinic = clinicService.findClinicById(clinicId);
        Patient patient = patientService.getPatientById(patientID);

        if (clinic == null || patient == null) {
            return new ResponseEntity<>("Doctor or patient not found", HttpStatus.NOT_FOUND);
        }

        if (clinic.getPatientList().contains(patient)) {
            return new ResponseEntity<>("Patient already exists in patient list for clinic", HttpStatus.CONFLICT);
        }

        clinic.getPatientList().add(patient);
        clinicService.updateClinic(clinicId,clinic);

        return new ResponseEntity<>("Added patient to list in clinic", HttpStatus.CREATED);
    }

    @PostMapping("/{clinicId}/add-doctor-to-clinic/{doctorId}")
    public ResponseEntity<String> addDoctorToClinic(@PathVariable Long clinicId, @PathVariable Long doctorId) throws Exception {
        Clinic clinic = clinicService.findClinicById(clinicId);
        Doctor doctor = doctorService.findById(doctorId);

        if (clinic == null || doctor == null) {
            return new ResponseEntity<>("Doctor or clinic not found", HttpStatus.NOT_FOUND);
        }

        if (clinic.getDoctorList().contains(doctor)) {
            return new ResponseEntity<>("doctor already exists in doctor list for clinic", HttpStatus.CONFLICT);
        }

        clinic.getDoctorList().add(doctor);
        clinicService.updateClinic(clinicId,clinic);

        return new ResponseEntity<>("Added doctor to list in clinic", HttpStatus.CREATED);
    }




}
