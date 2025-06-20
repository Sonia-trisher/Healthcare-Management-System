package org.example.healthcare.medicalRecord;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/medical-records")
@SecurityRequirement(name = "auth")
public class MedicalRecordContoller {
    private final MedicalRecordService medicalRecordService;
    @PostMapping
    @Operation(summary = "Create a medical record")
    public ResponseEntity<MedicalRecord> createMedicalRecord(@RequestBody MedicalRecordDtoo dtoo,@RequestParam long patientId , @RequestParam long doctorId) {
        MedicalRecord medicalRecord = medicalRecordService.createMedicalRecord(dtoo, patientId, doctorId);
        return new ResponseEntity<>(medicalRecord, HttpStatus.CREATED);
    }
    @GetMapping
    @Operation(summary = "Get all medical records, filter by patient or doctor")
    public ResponseEntity<List<MedicalRecord>> getAllMedicalRecord(){
        List<MedicalRecord> medicalRecords = medicalRecordService.findAllMedicalRecord();
        return new ResponseEntity<>(medicalRecords, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    @Operation(summary = "Get a medical record by ID.")
    public ResponseEntity<MedicalRecord> getMedicalRecordById(@PathVariable long id) {
        MedicalRecord medicalRecord = medicalRecordService.FindMedicalRecordById(id);
        return new ResponseEntity<>(medicalRecord, HttpStatus.OK);
    }


    @PutMapping("/{id}")
    @Operation(summary = "Update a medical record")
    public ResponseEntity<MedicalRecord> updateMedicalRecord(@PathVariable long id, @RequestBody MedicalRecordDtoo dtoo) {
        MedicalRecord medicalRecord = medicalRecordService.FindMedicalRecordById(id);
        return new ResponseEntity<>(medicalRecord, HttpStatus.OK);
    }




    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a medical record")
    public ResponseEntity<MedicalRecord> deleteMedicalRecord(@PathVariable Long id){
        medicalRecordService.deleteMedicalRecord(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
