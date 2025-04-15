//package com.keyin.patient;
//
//import com.keyin.insurance.Insurance;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.Mockito.*;
//
//public class PatientServiceTest {
//
//    @Mock
//    private PatientRepository patientRepository;
//
//    @InjectMocks
//    private PatientService patientService;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    public void testGetPatientById() {
//        Insurance insurance = new Insurance("Blue Cross", "123456789", "2023-01-01", "2024-01-01", "Jordan Kelloway");
//        Patient patient = new Patient(1L,"Jordan","Kelloway",30,"Male","123-123-1233",insurance);
//        when(patientRepository.findById(patient.getUserId())).thenReturn(Optional.of(patient));
//        Patient returned = patientService.getPatientById(1L);
//        assertEquals(patient,returned);
//        System.out.println(returned.getFirstName());
//    }
//
//    @Test
//    public void testRepoFindAll() {
//        Insurance insurance = new Insurance("Blue Cross", "123456789", "2023-01-01", "2024-01-01", "Jordan Kelloway");
//
//        Patient patient = new Patient(1L,"Jordan","Kelloway",30,"Male","123-123-1233");
//        Patient patient1 = new Patient(2L,"Jordannnn","Kelloway",30,"Male","123-123-1233");
//        when(patientRepository.findAll()).thenReturn(List.of(patient,patient1));
//        assertEquals(patientService.getPatients(),patientRepository.findAll());
//        assertEquals(2,patientRepository.findAll().size());
//
//    }
//
//    @Test
//    public void testSaveUser() {
//        Patient user = new Patient();
//        user.setFirstName("John");
//        user.setGender("Male");
//
//        when(patientRepository.save(user)).thenReturn(user);
//
//        Patient savedUser = patientService.createPatient(user);
//
//        assertNotNull(savedUser);
//        assertEquals("John", savedUser.getFirstName());
//        assertEquals("Male", savedUser.getGender());
//
//        verify(patientRepository, times(1)).save(user);
//    }
//}
