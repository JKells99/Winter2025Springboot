package com.keyin.patient;

import com.keyin.doctor.Doctor;
import com.keyin.doctor.DoctorRepository;
import com.keyin.doctor.DoctorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


public class DoctorServiceTest {

    @Mock
    private DoctorRepository doctorRepository;

    @InjectMocks
    private DoctorService doctorService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetPatientById() {
        Doctor doctor = new Doctor(1L, "Doctor", "Doctor", "Doctor", "Doctor");
        when(doctorRepository.findById(1L)).thenReturn(Optional.of(doctor));
        Assertions.assertEquals(doctorService.findById(doctor.getId()), doctor);
    }
}
