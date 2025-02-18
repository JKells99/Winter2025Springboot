package com.keyin.bloodpressure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BloodPressureService {
    @Autowired
    private BloodPressureRepository bloodPressureRepository;

    public Iterable<BloodPressure> getAllReadingsInSystem(){
        return bloodPressureRepository.findAll();
    }

    public void addBloodPressureToSystem(BloodPressure bloodPressure){
        bloodPressureRepository.save(bloodPressure);
    }
}
