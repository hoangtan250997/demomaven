package com.example.demomaven.service;

import com.example.demomaven.service.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
     List<EmployeeDto> getEmployeeByFirstName(String firstName);
}
