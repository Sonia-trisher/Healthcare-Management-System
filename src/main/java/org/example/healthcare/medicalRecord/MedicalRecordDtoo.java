package org.example.healthcare.medicalRecord;

import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
@Getter
@Setter
public class MedicalRecordDtoo {
    Long patientId;
    Long doctorId;
    @Length(message = "you can't exceed 255 characters", max = 255)
    private String diagnosis;

    @Length(message = "you can't exceed 500 characters", min = 0, max = 500)
    private String prescription;

    @PastOrPresent
    private LocalDateTime recordDate;

}
