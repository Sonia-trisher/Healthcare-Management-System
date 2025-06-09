package org.example.healthcare.user;

import lombok.Data;

import java.util.Date;

@Data
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private Date date_of_birth;
    }
