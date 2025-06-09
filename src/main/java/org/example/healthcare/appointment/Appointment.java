package org.example.healthcare.appointment;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import org.example.healthcare.doctor.Doctor;
import org.example.healthcare.patient.Patient;

import java.time.LocalDateTime;

public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Future(message = "Appointment date must be in the future")
    private LocalDateTime appointmentDate;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Doctor doctor;

    // unique constraint to avoid duplicate appointments
    @Column(unique = true)
    private String uniqueKey; // e.g., patientId + doctorId + appointmentDate

    @PrePersist
    public void generateKey() {
        this.uniqueKey = patient.getId() + "_" + doctor.getId() + "_" + appointmentDate.toString();
    }
}
}
