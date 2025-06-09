package org.example.healthcare.appointment;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppointmentDtoo {
    Long patientId;
    Long doctorId;
    private LocalDateTime appointmentDate;
    @Enumerated(EnumType.STRING)
    private Appointment.AppointmentStatus status;
    private String notes;

}
