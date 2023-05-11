package com.example.demomaven.service.impl;

import com.example.demomaven.repository.EmployeeRepository;
import com.example.demomaven.service.EmployeeService;
import com.example.demomaven.service.dto.EmployeeDto;
import com.example.demomaven.service.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeDto> getEmployeeByFirstName(String firstName) {

        return employeeMapper.toDtos(employeeRepository.getEmployeebyFirstname(firstName));
    }

}
