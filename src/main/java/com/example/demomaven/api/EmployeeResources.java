package com.example.demomaven.api;


import com.example.demomaven.entity.Employee;
import com.example.demomaven.exception.DemoException;
import com.example.demomaven.service.EmployeeService;
import com.example.demomaven.service.dto.EmployeeDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeResources {
    private final EmployeeService employeeService;

    @GetMapping("/names")
    ResponseEntity<List<EmployeeDto>> getEmployeeByFirstName(@RequestParam("firstName") @NotBlank String firstName){
        log.info("find employee by firstname {} ", firstName);
        if(firstName == null || firstName.isBlank())
            throw DemoException.badRequest("FirstNameEmpty", "First name is null or empty");

        return ResponseEntity.ok().body(employeeService.getEmployeeByFirstName(firstName));

    }
}
