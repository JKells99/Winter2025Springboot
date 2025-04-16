package com.keyin.insurance;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
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

}
