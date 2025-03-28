package com.keyin.patient;


import com.keyin.bloodpressure.BloodPressure;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String firstName;

    private String lastName;

    private int age;

    private String gender;

    private String phoneNumber;

    @OneToMany
    List<BloodPressure> bloodPressures;

    public Patient(Long userId, String firstName, String lastName, int age, String gender, String phoneNumber) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.bloodPressures = new ArrayList<BloodPressure>();
    }

    public Patient(String firstName, String lastName, int age, String gender, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    public Patient() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<BloodPressure> getBloodPressures() {
        return bloodPressures;
    }

    public void setBloodPressures(List<BloodPressure> bloodPressures) {
        this.bloodPressures = bloodPressures;
    }

    public void addBloodPressure(BloodPressure bloodPressure) {
        this.bloodPressures.add(bloodPressure);
    }


}
