package com.example.demomaven.service.impl;


import com.example.demomaven.entity.Department;
import com.example.demomaven.exception.DemoException;
import com.example.demomaven.repository.DepartmentRepository;
import com.example.demomaven.service.DepartmentService;
import com.example.demomaven.service.dto.DepartmentDto;
import com.example.demomaven.service.dto.DepartmentStatisticsDto;
import com.example.demomaven.service.mapper.DepartmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Override
    public List<DepartmentDto> getALl() {
        return DepartmentMapper.INSTANCE.toDtos(departmentRepository.findAll());
    }
    @Override
    public List<DepartmentStatisticsDto> getDepartmentStatistics() {
        return departmentRepository.countEmployeesInDepartments();
    }

    @Override
    public List<DepartmentStatisticsDto> getDepartmentStatisticsByJPAQL() {
        return departmentRepository.countEmployeesInDepartmentsJPAQL();
    }

    @Override
    public DepartmentDto findById(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(DemoException::DepartmentNotFound);
        return DepartmentMapper.INSTANCE.toDto(department);
    }
}
