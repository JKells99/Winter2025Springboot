package com.keyin.clinic;

import com.keyin.doctor.Doctor;
import com.keyin.patient.Patient;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
public class Clinic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clinicId;

    private String clinicName;

    private String clinicAddress;

    private String clinicPhoneNumber;

    @ManyToMany
    private List<Patient> patientList;

    @ManyToMany
    private List<Doctor> doctorList;

    public Clinic(String clinicName, String clinicAddress, String clinicPhoneNumber) {
        this.clinicName = clinicName;
        this.clinicAddress = clinicAddress;
        this.clinicPhoneNumber = clinicPhoneNumber;
        this.patientList = new ArrayList<>();
        this.doctorList = new ArrayList<>();

    }
    public Clinic() {
    }

    public void addToPatientList(Patient patient){
        patientList.add(patient);
    }

    public void addToDoctorList(Doctor doctor){
        doctorList.add(doctor);
    }
}
