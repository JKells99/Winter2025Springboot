package com.keyin.bloodpressure;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(exported = false)
public interface BloodPressureRepository extends JpaRepository<BloodPressure, Long> {


}
