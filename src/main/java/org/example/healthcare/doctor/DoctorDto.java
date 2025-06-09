package org.example.healthcare.doctor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DoctorDto {
    private String firstname;
    private String lastname;
    private String speciality;
    private String email;
}
