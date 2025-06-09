package org.example.healthcare.patient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientDto {
    private String firstname;
    private String lastname;
    private String phone;
    private String email;
}
