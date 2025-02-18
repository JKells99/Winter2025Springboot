package com.keyin.bloodpressure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/bloodpressure")
public class BloodPressureController {

    @Autowired
    private BloodPressureService bloodPressureService;


    @GetMapping("/getAllBpInSystem")
    public Iterable<BloodPressure> getAllBpInSystem() {
        return bloodPressureService.getAllReadingsInSystem();
    }




}
