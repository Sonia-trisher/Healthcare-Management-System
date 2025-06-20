package org.example.healthcare.medicalRecord;

import lombok.RequiredArgsConstructor;
import org.example.healthcare.doctor.Doctor;
import org.example.healthcare.doctor.DoctorRepository;
import org.example.healthcare.doctor.DoctorService;
import org.example.healthcare.patient.Patient;
import org.example.healthcare.patient.PatientRepository;
import org.example.healthcare.patient.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicalRecordService {
    private final MedicalRecordRepository medicalRecordRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    public MedicalRecord createMedicalRecord(MedicalRecordDtoo dtoo,long patientId,long doctorId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(()->new RuntimeException("Patient not found"));;
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(()->new RuntimeException("Doctor not found"));
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setDiagnosis(dtoo.getDiagnosis());
        medicalRecord.setPrescription(dtoo.getPrescription());
        medicalRecord.setRecordDate(dtoo.getRecordDate());
        medicalRecord.setPatient(patient);
        medicalRecord.setDoctor(doctor);

        patient.getMedicalRecords().add(medicalRecord);
        doctor.getMedicalRecords().add(medicalRecord);




        return medicalRecordRepository.save(medicalRecord);

    }

    public List<MedicalRecord> findAllMedicalRecord(){
        return medicalRecordRepository.findAll();

    }
    public MedicalRecord FindMedicalRecordById(Long id){
        return medicalRecordRepository.findById(id).orElseThrow(() -> new RuntimeException("Medical record not found"));

    }
    public MedicalRecord updateMedicalRecord(Long id, MedicalRecordDtoo dtoo){
        MedicalRecord medicalRecord = medicalRecordRepository.findById(id)
                .orElseThrow(()->new RuntimeException("MedicalRecord not found"));
        medicalRecord.setDiagnosis(dtoo.getDiagnosis());
        medicalRecord.setPrescription(dtoo.getPrescription());
        return medicalRecordRepository.save(medicalRecord);
    }
    public void deleteMedicalRecord(Long id){
         medicalRecordRepository.deleteById(id);
    }
}
