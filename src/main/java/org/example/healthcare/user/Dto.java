package org.example.healthcare.user;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dto {
    @NotBlank(message = "Please enter your first name")
    @Size(max = 50, message ="your name should not exceed 50 characters" )
    private String firstName;
    @NotBlank(message = "Please enter your last name")
    @Size(max = 50, message ="your name should not exceed 50 charchaters" )
    private String lastName;
    @NotBlank(message = "Please enter your password")
    @Size(min = 5, message ="your password should atleast be above 6 characters" )
    private String password;
    @Column(unique = true)
    @Email
    private String email;
    @Size(max = 20, message = "your number should not exceed 20 numbers")
    private String phone;
    @NotBlank(message = "enter your date of birth")
    @Past(message = "your date of birth should be in the past")
    private Date date_of_birth;
}
