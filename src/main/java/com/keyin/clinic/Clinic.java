package com.keyin.clinic;

import com.keyin.doctor.Doctor;
import com.keyin.patient.Patient;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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

    public Long getClinicId() {
        return clinicId;
    }

    public void setClinicId(Long clinicId) {
        this.clinicId = clinicId;
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    public String getClinicAddress() {
        return clinicAddress;
    }

    public void setClinicAddress(String clinicAddress) {
        this.clinicAddress = clinicAddress;
    }

    public String getClinicPhoneNumber() {
        return clinicPhoneNumber;
    }

    public void setClinicPhoneNumber(String clinicPhoneNumber) {
        this.clinicPhoneNumber = clinicPhoneNumber;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<Doctor> doctorList) {
        this.doctorList = doctorList;
    }

    public void addToPatientList(Patient patient){
        patientList.add(patient);
    }

    public void addToDoctorList(Doctor doctor){
        doctorList.add(doctor);
    }
}
