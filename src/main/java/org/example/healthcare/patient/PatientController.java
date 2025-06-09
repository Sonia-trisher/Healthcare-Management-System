package org.example.healthcare.patient;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping("/all")
    @Operation(summary = "Get all patients")
    public List<Patient> getAll() {
        return patientService.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get patient by ID")
    public Patient getById(@PathVariable long id) {
        return patientService.getById(id);
    }

    @PostMapping("/create")
    @Operation(summary = "Create a new patient")
    public Patient create(@RequestBody @Valid PatientDto patientDto) {
        Patient patient = new Patient();
        patient.setFirstname(patientDto.getFirstname());
        patient.setLastname(patientDto.getLastname());
        patient.setEmail(patientDto.getEmail());
        patient.setPhone(patientDto.getPhone());
        return patientService.create(patient);
    }

    @PatchMapping("/update/{id}")
    @Operation(summary = "Update patient information")
    public Patient update(@PathVariable long id, @RequestBody @Valid PatientDto patientDto) {
        return patientService.update(id, patientDto);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete patient by ID")
    public Patient delete(@PathVariable long id) {
        return patientService.delete(id);
    }
}
