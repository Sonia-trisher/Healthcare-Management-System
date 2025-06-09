package org.example.healthcare.medicalRecord;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;
import org.example.healthcare.doctor.Doctor;
import org.example.healthcare.patient.Patient;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;


@Getter
@Setter
@Entity
public class MedicalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(message = "you can't exceed 255 characters", max = 255)
    @Column(nullable = false)
    private String diagnosis;

    @Length(message = "you can't exceed 500 characters", min = 0, max = 500)
    @Column(length = 500)
    private String prescription;


    @PastOrPresent
    @Column(nullable = false)
    private LocalDateTime recordDate;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    @JsonBackReference("patient_medicalrecords")
    private Patient patient;


    @ManyToOne
    @JoinColumn(name = "doctor_id")
    @JsonBackReference("doctor_medicalrecords")
    private Doctor doctor;
}
