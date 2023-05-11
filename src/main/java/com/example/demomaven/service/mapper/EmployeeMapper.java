package com.example.demomaven.service.mapper;

import com.example.demomaven.entity.Employee;
import com.example.demomaven.service.dto.EmployeeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mapping(target = "departmentName", source = "department.name")
    EmployeeDto toDto(Employee employee);

    List<EmployeeDto> toDtos(List<Employee> employees);

}
