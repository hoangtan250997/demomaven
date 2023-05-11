package com.example.demomaven.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

@Table(name = "demo_department")
@SqlResultSetMapping(
        name = "DepartmentEmployeeStatistics",
        classes = {
                @ConstructorResult(
                        targetClass = com.example.demomaven.service.dto.DepartmentStatisticsDto.class,
                        columns = {
                                @ColumnResult(name = "departmentName", type = String.class),
                                @ColumnResult(name = "numberOfEmployee", type = Long.class)})})
@NamedNativeQuery(
        name = Department.COUNT_EMPLOYEES_IN_DEPARTMENT,
        query = "SELECT d.name as departmentName, count(e.id) as numberOfEmployee " +
                "FROM demo_department d left join demo_employee e on d.id = e.dept_id " +
                "GROUP BY d.name ORDER BY d.name",
        resultSetMapping = "DepartmentEmployeeStatistics")
public class Department {
    public static final String COUNT_EMPLOYEES_IN_DEPARTMENT = "Department.countEmployeesInDepartments";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dept_name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private Location location;

}
