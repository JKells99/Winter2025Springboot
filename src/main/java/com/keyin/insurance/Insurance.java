package com.keyin.insurance;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long insuranceId;
    private String insuranceName;
    private String insuranceType;
    private String insuranceNumber;
    private String insuranceExpiryDate;
    private String insuranceProvider;

    public Insurance(Long insuranceId, String insuranceName, String insuranceType, String insuranceNumber, String insuranceExpiryDate, String insuranceProvider) {
        this.insuranceId = insuranceId;
        this.insuranceName = insuranceName;
        this.insuranceType = insuranceType;
        this.insuranceNumber = insuranceNumber;
        this.insuranceExpiryDate = insuranceExpiryDate;
        this.insuranceProvider = insuranceProvider;
    }

    public Insurance(String insuranceName, String insuranceType, String insuranceNumber, String insuranceExpiryDate, String insuranceProvider) {
        this.insuranceName = insuranceName;
        this.insuranceType = insuranceType;
        this.insuranceNumber = insuranceNumber;
        this.insuranceExpiryDate = insuranceExpiryDate;
        this.insuranceProvider = insuranceProvider;
    }

    public Insurance() {

    }

    public Long getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(Long insuranceId) {
        this.insuranceId = insuranceId;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public String getInsuranceExpiryDate() {
        return insuranceExpiryDate;
    }

    public void setInsuranceExpiryDate(String insuranceExpiryDate) {
        this.insuranceExpiryDate = insuranceExpiryDate;
    }

    public String getInsuranceProvider() {
        return insuranceProvider;
    }

    public void setInsuranceProvider(String insuranceProvider) {
        this.insuranceProvider = insuranceProvider;
    }
}
