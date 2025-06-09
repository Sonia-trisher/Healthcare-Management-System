package org.example.healthcare.appointment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findAppointmentByPatientIdAndDoctorIdAndAppointmentDate(Long patientId, Long doctorId, LocalDateTime appointmentDate);
}
