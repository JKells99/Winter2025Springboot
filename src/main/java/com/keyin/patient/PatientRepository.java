package com.keyin.patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PatientRepository  extends JpaRepository<Patient, Long> {

    Patient findByFirstName(String name);


}
