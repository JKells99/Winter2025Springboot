package com.keyin.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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

    public void deletePatientById(Long id) {
        patientRepository.deleteById(id);
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    public Patient updatePatient(Long patientId, Patient patientDetails) throws Exception {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new Exception("Patient not found"));
        patient.setFirstName(patientDetails.getFirstName());
        patient.setLastName(patientDetails.getLastName());
        patient.setGender(patientDetails.getGender());
        patient.setAge(patientDetails.getAge());
        patient.setPhoneNumber(patientDetails.getPhoneNumber());
        patient.setBloodPressures(patientDetails.getBloodPressures());

        return patientRepository.save(patient);
    }


}
