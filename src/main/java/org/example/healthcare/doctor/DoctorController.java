package org.example.healthcare.doctor;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
@SecurityRequirement(name = "auth")
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    @Operation(summary = "Get all doctors")
    public List<Doctor> getAll() {
        return doctorService.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get doctor by ID")
    public Doctor getById(@PathVariable long id) {
        return doctorService.getById(id);
    }

    @PostMapping
    @Operation(summary = "Insert doctor")
    public Doctor create(@RequestBody Doctor doctor) {
        return doctorService.create(doctor);
    }

    @PatchMapping("/update/{id}")
    @Operation(summary = "Update doctor")
    public Doctor update(@PathVariable long id, @RequestBody DoctorDto doctorDto) {
        return doctorService.update(id, doctorDto);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete doctor by ID")
    public Doctor deleteById(@PathVariable long id) {
        return doctorService.delete(id);
    }
}
