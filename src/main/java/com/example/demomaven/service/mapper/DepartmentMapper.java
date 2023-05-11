package com.example.demomaven.service.mapper;

import com.example.demomaven.entity.Department;
import com.example.demomaven.service.dto.DepartmentDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DepartmentMapper {
    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);


    DepartmentDto toDto(Department department);

    List<DepartmentDto> toDtos(List<Department> departments);

}
