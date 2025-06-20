package org.example.healthcare.doctor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }


    public List<Doctor> getAll() {
        return doctorRepository.findAll();
    }


    public Doctor getById(long id) {
        return doctorRepository.findById(id).orElseThrow();
    }


    public Doctor create(DoctorDto dtoo) {
        Doctor doctor = new Doctor();
        doctor.setFirstname(dtoo.getFirstname());
        doctor.setLastname(dtoo.getLastname());
        doctor.setSpeciality(dtoo.getSpeciality());
        doctor.setEmail(dtoo.getEmail());
        return doctorRepository.save(doctor);
    }


    public Doctor update(long id, DoctorDto dtoo) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow();
        doctor.setFirstname(dtoo.getFirstname());
        doctor.setSpeciality(dtoo.getSpeciality());
        return doctorRepository.save(doctor);
    }


    public Doctor delete(long id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow();
        doctorRepository.deleteById(id);
        return doctor;
    }
}
