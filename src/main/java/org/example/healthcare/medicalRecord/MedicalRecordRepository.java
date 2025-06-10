package org.example.healthcare.medicalRecord;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {
    List<MedicalRecord> findByPatientIdAndDoctorId(Long patientId,Long doctorId);
}
