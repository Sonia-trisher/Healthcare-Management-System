package org.example.healthcare.appointment;
//
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@AllArgsConstructor
//public class AppointmentService {
//    private final AppointmentRepository appointmentRepository;
//
//    public List<Appointment> findAllAppointments(){
//        return appointmentRepository.findAll();
//    }
//    public Optional<Appointment> findAppointmentById(Long id){
//        return appointmentRepository.findById(id);
//    }
//    public Appointment saveAppointment(Appointment appointment){
//        if(appointmentRepository.existsByPatientIdAndDoctorIdAndAppointmentDate(
//                appointment.getPatient().getId(),
//                appointment.getDoctor().getId(),
//                appointment.getAppointmentDate())){
//            throw new IllegalArgumentException("Appointment already exists");
//        }
//        return appointmentRepository.save(appointment);
//    }
//    public Appointment updateAppointment(Long id,Appointment appointment){
//        Appointment appointmentToUpdate = appointmentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Appointment not found"));
//        appointment.setPatient(appointmentToUpdate)
//
//    }

//}