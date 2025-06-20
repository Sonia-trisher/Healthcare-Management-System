package org.example.healthcare.appointment;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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
@SecurityRequirement(name = "auth")
public class AppointmentController {
    private final AppointmentService appointmentService;

    @PostMapping
    @Operation(summary = "Create an appointment.")
    public ResponseEntity<Appointment> createAppointment(@RequestBody AppointmentDtoo Dtoo , @RequestParam long patientId , @RequestParam long doctorId){
        Appointment appointment = appointmentService.createAppointment(Dtoo , patientId , doctorId);
        return new ResponseEntity<>(appointment, HttpStatus.CREATED);
    }
    @GetMapping
    @Operation(summary = "Get all appointments ")
    public ResponseEntity<List<Appointment>> findAllAppointments(){
        List<Appointment> appointments = appointmentService.findAllAppointments();
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    @GetMapping("/id")
    @Operation(summary = "Get an appointment by ID")
    public ResponseEntity<Appointment> findAppointmentById(@RequestParam Long id){
        Appointment appointment = appointmentService.findAppointmentById(id);
        return new ResponseEntity<>( appointment,HttpStatus.OK);
    }
    @PutMapping("/id")
    @Operation(summary = " Update an appointment")
    public ResponseEntity<Appointment> updateAppointment(@RequestParam Long id ,@RequestBody AppointmentDtoo dtoo){
        Appointment appointment = appointmentService.updateAppointment(id, dtoo);
        return new ResponseEntity<>(appointment, HttpStatus.OK);
    }
    @DeleteMapping("/id")
    @Operation(summary = " Delete an appointment")
    public ResponseEntity<Appointment> deleteAppointment(@RequestParam Long id){
        appointmentService.deleteAppointment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
