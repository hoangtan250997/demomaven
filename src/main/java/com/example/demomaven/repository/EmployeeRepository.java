package com.example.demomaven.repository;

import com.example.demomaven.entity.Employee;
import com.example.demomaven.service.dto.EmployeeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("SELECT new com.example.demomaven.service.dto.EmployeeDto(e.firstName, d.name, e.gender, e.dateOfBirth) " +
            "FROM Employee e, Department d WHERE e.department.id = d.id and d.id = :deptid ")
    List<EmployeeDto> getEmployeeInADepartment(@Param("deptid") Long deptid);

    @Query(value="SELECT e.* FROM com_employee e WHERE e.first_name like CONCAT('%',:firstName,'%')", nativeQuery = true)
    List<Employee> getEmployeebyFirstname(@Param("firstName") String firstname);



}
