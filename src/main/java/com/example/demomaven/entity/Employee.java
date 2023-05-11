package com.example.demomaven.entity;

import com.example.demomaven.service.mapper.GenderAttributeConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.YearMonth;

@Entity
@Table(name = "com_employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    @Convert(converter = GenderAttributeConverter.class)
    private Gender gender;

    private LocalDate dateOfBirth;

    @ManyToOne
    @JoinColumn(name="dept_id")
    private Department department;

}
