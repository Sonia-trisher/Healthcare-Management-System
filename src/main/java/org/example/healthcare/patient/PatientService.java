package org.example.healthcare.patient;

import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class PatientService {
    private final PatientRepository patientRepository;
    public PatientService(PatientRepository patientRepository){
        this.patientRepository=patientRepository;
    }
    public List<Patient> getAll(){
        return patientRepository.findAll();
    }
    public Patient getById(long id){
        return patientRepository.findById(id).orElseThrow();

    }
    public Patient create(Patient patient){
        return patientRepository.save(patient);
    }
    public  Patient update(long id, PatientDto patientDto){
        Patient patient=patientRepository.findById(id).orElseThrow();
        patient.setFirstname(patientDto.getFirstname());
        patient.setLastname(patientDto.getLastname());
        patient.setEmail(patientDto.getEmail());
        patient.setPhone(patientDto.getPhone());
        return patientRepository.save(patient);

    }
 public Patient delete(long id){
        Patient patient=patientRepository.findById(id).orElseThrow();
        patientRepository.delete(patient);
     return patient;
 }


}
