package org.example.healthcare.user;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginRequest {
    @Column(unique = true)
    @Email
    private String email;
    @NotBlank(message = "Please enter your password")
    @Size(min = 5, message ="your password should atleast be above 6 characters" )
    private String password;
}
