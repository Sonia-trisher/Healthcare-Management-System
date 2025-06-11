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
    public ResponseEntity<MedicalRecord> createMedicalRecord(@RequestBody MedicalRecordDtoo dtoo){
        MedicalRecord medicalRecord = medicalRecordService.createMedicalRecord(dtoo);
        return new ResponseEntity<>(medicalRecord, HttpStatus.CREATED);
    }
    @GetMapping
    @Operation(summary = "Get all medical records, filter by patient or doctor")
    public ResponseEntity<List<MedicalRecord>> getAllMedicalRecords(@RequestBody Long patientId,@RequestBody Long doctorId){
        List<MedicalRecord> medicalRecords = medicalRecordService.findAllMedicalRecord( patientId, doctorId);
        return new ResponseEntity<>(medicalRecords, HttpStatus.OK);
    }
    @GetMapping("/id")
    @Operation(summary = "Get a medical record by ID.")
    public ResponseEntity<MedicalRecord> getMedicalRecords (@PathVariable Long id){
        MedicalRecord medicalRecord = medicalRecordService.FindMedicalRecordById(id);
        return new ResponseEntity<>(medicalRecord, HttpStatus.OK);
    }
    @PutMapping("/id")
    @Operation(summary = "Update a medical record")
    public ResponseEntity<MedicalRecord> updateMedicalRecord(Long id,@RequestBody MedicalRecordDtoo dtoo){
        MedicalRecord medicalRecord = medicalRecordService.updateMedicalRecord(id,dtoo);
        return new ResponseEntity<>(medicalRecord, HttpStatus.OK);
    }
    @DeleteMapping("/id")
    @Operation(summary = "Delete a medical record")
    public ResponseEntity<MedicalRecord> deleteMedicalRecord(@PathVariable Long id){
        medicalRecordService.deleteMedicalRecord(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
