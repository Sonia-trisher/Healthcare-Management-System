package org.example.healthcare.appointment;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    @PostMapping
    @Operation(summary = "Create an appointment.")
    public ResponseEntity<Appointment> createAppointment(@RequestBody AppointmentDtoo Dtoo){
        Appointment appointment = appointmentService.createAppointment(Dtoo);
        return new ResponseEntity<>(appointment, HttpStatus.CREATED);
    }
    @GetMapping
    @Operation(summary = "Get all appointments filted by patient ,doctor,appointmentDate")
    public ResponseEntity<List<Appointment>> findAllAppointments(@RequestBody Long patientId, @RequestBody Long doctorId, @RequestBody LocalDateTime date){
        List<Appointment> appointments = appointmentService.findAllAppointments(patientId, doctorId, date);
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    @GetMapping("/id")
    @Operation(summary = "Get an appointment by ID")
    public ResponseEntity<Appointment> findAppointmentById(@PathVariable Long id){
        Appointment appointment = appointmentService.findAppointmentById(id);
        return new ResponseEntity<>( appointment,HttpStatus.OK);
    }
    @PutMapping("/id")
    @Operation(summary = " Update an appointment")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable Long id ,@RequestBody AppointmentDtoo dtoo){
        Appointment appointment = appointmentService.updateAppointment(id, dtoo);
        return new ResponseEntity<>(appointment, HttpStatus.OK);
    }
    @DeleteMapping("/id")
    @Operation(summary = " Delete an appointment")
    public ResponseEntity<Appointment> deleteAppointment(@PathVariable Long id){
        appointmentService.deleteAppointment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
