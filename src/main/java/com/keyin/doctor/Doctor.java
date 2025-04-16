package com.keyin.doctor;

import com.keyin.patient.Patient;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String speciality;
    private String phoneNumber;

    @OneToMany
    private List<Patient> patientList;

    public Doctor(String phoneNumber, String speciality, String lastName, String firstName, Long id) {
        this.phoneNumber = phoneNumber;
        this.speciality = speciality;
        this.lastName = lastName;
        this.firstName = firstName;
        this.id = id;
        this.patientList = new ArrayList<>();
    }

    public Doctor() {
        this.patientList = new ArrayList<>();
    }

    public Doctor(Long id, String firstName, String lastName, String speciality, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.speciality = speciality;
        this.phoneNumber = phoneNumber;
        this.patientList = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        this.patientList.add(patient);
    }
    public void removePatient(Patient patient) {
        this.patientList.remove(patient);
    }

}
