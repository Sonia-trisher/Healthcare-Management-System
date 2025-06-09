package org.example.healthcare.appointment;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.example.healthcare.doctor.Doctor;
import org.example.healthcare.patient.Patient;

import java.time.LocalDateTime;

public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Future(message = "Appointment date must be in the future")
    @Column(name = "appointment_date", nullable = false)
    private LocalDateTime appointmentDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

    public enum AppointmentStatus {
        SCHEDULED,
        COMPLETED,
        CANCELLED
    }

    @ManyToOne
    @JoinColumn(name = "patient_id")
    @JsonBackReference
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    @JsonBackReference
    private Doctor doctor;


    @Column(unique = true)
    private String note;



}
