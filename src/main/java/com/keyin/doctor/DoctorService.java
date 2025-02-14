package com.keyin.doctor;

import com.keyin.patient.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collections;

@Service
@CrossOrigin(origins = "*")
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Iterable<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }

    public Doctor createDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
        return doctor;
    }

    public void deleteDoctorById(Long id) {
        doctorRepository.deleteById(id);
    }

    public Doctor findById(Long id) {
        return doctorRepository.findById(id).orElse(null);

    }


    public Iterable<Patient> listPatientsByDoctorId(Long doctorId) {
        return doctorRepository.findById(doctorId)
                .map(Doctor::getPatientList)
                .orElse(Collections.emptyList());
    }

}
