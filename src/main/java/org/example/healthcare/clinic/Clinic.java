package org.example.healthcare.clinic;

import jakarta.persistence.*;
import lombok.Data;

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
}
