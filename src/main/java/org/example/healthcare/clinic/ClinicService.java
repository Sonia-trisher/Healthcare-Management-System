package org.example.healthcare.clinic;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicService {
    private final ClinicRepository clinicRepository;
    public  ClinicService(ClinicRepository clinicRepository){
        this.clinicRepository=clinicRepository;
    }
    public List<Clinic> getAll(){
      return clinicRepository.findAll();

    }
    public Clinic getById( long id){
        return clinicRepository.findById(id).orElseThrow();

    }
    public Clinic create(Clinic clinic){
        return clinicRepository.save(clinic);
    }
    public Clinic update(long id, ClinicDto clinicDto) {
        Clinic clinic = clinicRepository.findById(id).orElseThrow();
        clinic.setName(clinicDto.getName());
        clinic.setAddress(clinicDto.getAddress());
        clinic.setPhone(clinicDto.getPhone());
        return clinicRepository.save(clinic);
    }

    public Clinic delete(long id) {
        Clinic clinic = clinicRepository.findById(id).orElseThrow();
        clinicRepository.deleteById(id);
        return clinic;
    }}
