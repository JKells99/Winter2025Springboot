package com.keyin.bloodpressure;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodPressureRepository extends JpaRepository<BloodPressure, Long> {


}
