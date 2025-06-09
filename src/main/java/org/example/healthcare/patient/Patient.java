package org.example.healthcare.patient;

import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import java.time.LocalDate;
import lombok.Data;

@Entity
@Table(name = "patients")
@Data

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
    @Column(nullable = false)
    @Past(message = "date of birth must be iin past")
    private LocalDate dateOfBirth;

}
