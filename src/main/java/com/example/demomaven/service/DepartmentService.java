package com.example.demomaven.service;

import com.example.demomaven.service.dto.DepartmentDto;
import com.example.demomaven.service.dto.DepartmentStatisticsDto;

import java.util.List;

public interface DepartmentService {
    List<DepartmentDto> getALl();
    List<DepartmentStatisticsDto> getDepartmentStatistics();
    List<DepartmentStatisticsDto> getDepartmentStatisticsByJPAQL();

    DepartmentDto findById(Long departmentId);

}
