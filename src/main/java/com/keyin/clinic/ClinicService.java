package com.keyin.clinic;

import com.keyin.patient.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClinicService {

    @Autowired
    ClinicRepository clinicRepository;

    public Clinic createANewClinic(Clinic clinic){
        clinicRepository.save(clinic);

        return clinic;
    }

    public Iterable<Clinic> getListOfClinics(){
        return clinicRepository.findAll();
    }

    public Clinic findClinicById(Long clinicId){
        return clinicRepository.findById(clinicId).orElse(null);
    }

    public Clinic updateClinic(Long clinicId, Clinic clinicDetails) {
        Clinic clinic = clinicRepository.findById(clinicId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found"));
        clinic.setClinicName(clinicDetails.getClinicName());
        clinic.setClinicAddress(clinicDetails.getClinicAddress());
        clinic.setClinicPhoneNumber(clinicDetails.getClinicPhoneNumber());
        clinic.setPatientList(clinicDetails.getPatientList());
        clinic.setDoctorList(clinicDetails.getDoctorList());


        return clinicRepository.save(clinic);
    }


}
