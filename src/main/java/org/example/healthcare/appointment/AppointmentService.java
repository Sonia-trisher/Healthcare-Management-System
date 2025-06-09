package org.example.healthcare.appointment;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.healthcare.doctor.Doctor;
import org.example.healthcare.doctor.DoctorRepository;
import org.example.healthcare.patient.Patient;
import org.example.healthcare.patient.PatientRepository;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public Appointment createAppointment(AppointmentDtoo dtoo) {
        Patient patient = patientRepository.findById(dtoo.getPatientId())
                .orElseThrow(()->new RuntimeException("Patient not found"));
        Doctor doctor = doctorRepository.findById(dtoo.getDoctorId())
                .orElseThrow(()->new RuntimeException("Doctor not found"));
        Appointment appointment = new Appointment();
        appointment.setStatus(dtoo.getStatus());
        appointment.setNotes(dtoo.getNotes());
        appointment.setAppointmentDate(dtoo.getAppointmentDate());
        return appointmentRepository.save(appointment);

    }

    public List<Appointment> findAllAppointments(Long patientId, Long doctorId, LocalDateTime appointmentDate){
        return appointmentRepository.findAppointmentByPatientIdAndDoctorIdAndAppointmentDate(patientId, doctorId, appointmentDate);
    }
    public Appointment findAppointmentById(Long id){
        return appointmentRepository.findById(id).orElseThrow();
    }

    public Appointment updateAppointment(Long id,AppointmentDtoo dtoo){
        Appointment appointmentToUpdate = appointmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Appointment not found"));
        return appointmentRepository.save(appointmentToUpdate);

    }
    public void deleteAppointment(Long id){
        appointmentRepository.deleteById(id);
    }

}