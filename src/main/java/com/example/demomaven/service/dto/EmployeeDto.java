package com.example.demomaven.service.dto;

import com.example.demomaven.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private String firstName;
    private String departmentName;
    private Gender gender;
    private LocalDate dateOfBirth;
}
