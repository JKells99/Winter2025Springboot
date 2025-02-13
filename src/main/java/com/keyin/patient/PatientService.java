package com.keyin.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Iterable<Patient> getPatients() {
        return patientRepository.findAll();
    }


    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public void deletePatientById(int id) {
        patientRepository.deleteById(id);
    }


}
