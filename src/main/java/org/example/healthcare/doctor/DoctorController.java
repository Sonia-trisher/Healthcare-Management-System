package org.example.healthcare.doctor;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")


public class DoctorController {

    private final DoctorService doctorService;
    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
    @GetMapping
    @Operation(summary = "/get/all/doctors")
    public List<Doctor> getAll(){
        return doctorService.getAll();
    }
    @GetMapping
    @Operation(summary = "/get/doctors/by/id")
    public Doctor getById(@PathVariable long id){
        return doctorService.getById(id);
    }
    @PostMapping
    @Operation(summary = "/insert/doctor")
     public  Doctor create(Doctor doctor){
        return doctorService.create(doctor);
     }
     @PatchMapping
     @Operation(summary = "/update/doctors")
     public  Doctor update( @PathVariable long id ,DoctorDto doctorDto){
        return doctorService.update(id, doctorDto);
     }
     @DeleteMapping
     @Operation(summary = "/delete/doctor/by/id")
     public Doctor deleteById(@PathVariable  long id){
        return doctorService.delete(id);
     }
}
