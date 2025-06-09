package org.example.healthcare.clinic;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.example.healthcare.doctor.Doctor;
import org.example.healthcare.patient.Patient;

import java.util.List;

@Entity
@Table(name = "clinics")
@Data

public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false,unique = true)
    private String phone;

    @OneToMany(mappedBy = "clinic",orphanRemoval = true)
    @JsonManagedReference("clinic-doctors")
    private List<Doctor> doctor;

    @OneToMany(mappedBy = "clinic",orphanRemoval = true)
    @JsonManagedReference("clinic_patients")
    private List<Patient> patient;

}
