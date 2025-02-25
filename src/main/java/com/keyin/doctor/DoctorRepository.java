package com.keyin.doctor;

import com.keyin.patient.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource(exported = false)
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
