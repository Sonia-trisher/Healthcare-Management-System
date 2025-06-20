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
    public Clinic create(ClinicDto dtoo){
        Clinic clinic=new Clinic();
        clinic.setName(dtoo.getName());
        clinic.setAddress(dtoo.getAddress());
        clinic.setPhone(dtoo.getPhone());
        return clinicRepository.save(clinic);
    }
    public Clinic update(long id, ClinicDto clinicDto) {
        Clinic clinicUpdate = clinicRepository.findById(id).orElseThrow();
        clinicUpdate.setName(clinicDto.getName());
        clinicUpdate.setAddress(clinicDto.getAddress());
        return clinicRepository.save(clinicUpdate);
    }

    public Clinic delete(long id) {
        Clinic clinic = clinicRepository.findById(id).orElseThrow();
        clinicRepository.deleteById(id);
        return clinic;
    }}
