package com.keyin.bloodpressure;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

    public Long getBloodPressureid() {
        return bloodPressureid;
    }

    public void setBloodPressureid(Long bloodPressureid) {
        this.bloodPressureid = bloodPressureid;
    }

    public int getSystolicPressure() {
        return systolicPressure;
    }

    public void setSystolicPressure(int systolicPressure) {
        this.systolicPressure = systolicPressure;
    }

    public int getDiastolicPressure() {
        return diastolicPressure;
    }

    public void setDiastolicPressure(int diastolicPressure) {
        this.diastolicPressure = diastolicPressure;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public LocalDateTime getTimeOfReading() {
        return timeOfReading;
    }

    public void setTimeOfReading(LocalDateTime timeOfReading) {
        this.timeOfReading = timeOfReading;
    }
}
