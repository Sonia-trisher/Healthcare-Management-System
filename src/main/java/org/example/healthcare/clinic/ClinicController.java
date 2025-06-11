package org.example.healthcare.clinic;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clinics")
@SecurityRequirement(name = "auth")
public class ClinicController {

    private final ClinicService clinicService;

    @Autowired
    public ClinicController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }


    @GetMapping
    @Operation(summary="/get/all/clinics")
    public List<Clinic> getAllClinics() {
        return clinicService.getAll();
    }


    @GetMapping("/{id}")

    public Clinic getClinicById(@PathVariable long id) {
        return clinicService.getById(id);
    }


    @PostMapping
    public Clinic createClinic(@RequestBody Clinic clinic) {
        return clinicService.create(clinic);
    }


    @PutMapping("/{id}")
    public Clinic updateClinic(@PathVariable long id, @RequestBody ClinicDto clinicDto) {
        return clinicService.update(id, clinicDto);
    }


    @DeleteMapping("/{id}")
    public Clinic deleteClinic(@PathVariable long id) {
        return clinicService.delete(id);
    }
}
