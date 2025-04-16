package com.keyin.patient;


import com.keyin.bloodpressure.BloodPressure;
import com.keyin.insurance.Insurance;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
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

    @OneToOne
    Insurance insurance;


    public Patient(Long userId, String firstName, String lastName, int age, String gender, String phoneNumber,Insurance insurance) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.bloodPressures = new ArrayList<BloodPressure>();
        this.insurance = insurance;
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

    public void addBloodPressure(BloodPressure bloodPressure) {
        this.bloodPressures.add(bloodPressure);
    }

}
