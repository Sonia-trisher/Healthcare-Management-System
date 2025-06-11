package org.example.healthcare.patient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.*;
import org.example.healthcare.appointment.Appointment;
import org.example.healthcare.clinic.Clinic;
import org.example.healthcare.medicalRecord.MedicalRecord;

@Entity
@Table(name = "patients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false)
    private String lastname;
    @Column(nullable = false,unique = true)
    private String phone;
    @Column(nullable = false,unique = true)
    private String email;
    @Past(message = "date of birth must be iin past")
    private LocalDate dateOfBirth;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("patient-appointments")
    private List<Appointment> appointments = new ArrayList<>();

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("patient-medicalrecords")
    private List<MedicalRecord> medicalRecords = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "clinic_id")
    @JsonBackReference("clinic_patients")
    private Clinic clinic;

}
