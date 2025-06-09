package org.example.healthcare.clinic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ClinicDto {

    private String name;
    private String address;
    private String phone;
}
