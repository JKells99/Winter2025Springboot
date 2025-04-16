package com.keyin.bloodpressure;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class BloodPressure {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bloodPressureid;

    private int systolicPressure;
    private int diastolicPressure;
    private int heartRate;
    private LocalDateTime timeOfReading = LocalDateTime.now();

    public BloodPressure(Long bloodPressureid, int systolicPressure, int diastolicPressure, int heartRate) {
        this.bloodPressureid = bloodPressureid;
        this.systolicPressure = systolicPressure;
        this.diastolicPressure = diastolicPressure;
        this.heartRate = heartRate;
        this.timeOfReading = LocalDateTime.now();

    }

    public BloodPressure(int systolicPressure, int diastolicPressure, int heartRate) {
        this.systolicPressure = systolicPressure;
        this.diastolicPressure = diastolicPressure;
        this.heartRate = heartRate;
        this.timeOfReading = LocalDateTime.now();
    }

    public BloodPressure() {
    }

}
