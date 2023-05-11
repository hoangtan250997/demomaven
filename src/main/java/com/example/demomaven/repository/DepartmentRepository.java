package com.example.demomaven.repository;

import com.example.demomaven.entity.Department;
import com.example.demomaven.service.dto.DepartmentStatisticsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface    DepartmentRepository extends JpaRepository<Department,Long> {

    @Query(nativeQuery=true)
    List<DepartmentStatisticsDto> countEmployeesInDepartments();

    @Query("SELECT new com.example.demomaven.service.dto.DepartmentStatisticsDto(d.name, count(e.id)) " +
            "FROM Department d left join Employee e on d.id = e.department.id " +
            "GROUP BY d.name ORDER BY d.name")
    List<DepartmentStatisticsDto> countEmployeesInDepartmentsJPAQL();
}
