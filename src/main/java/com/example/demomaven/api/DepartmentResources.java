package com.example.demomaven.api;

import com.example.demomaven.service.DepartmentService;
import com.example.demomaven.service.dto.DepartmentDto;
import com.example.demomaven.service.dto.DepartmentStatisticsDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/departments")
public class DepartmentResources {
    private final DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartment()  {
        return ResponseEntity.ok().body(departmentService.getALl());
    }

    @GetMapping("/statistics")
    public ResponseEntity<List<DepartmentStatisticsDto>> getDepartmentStatistics(){
           return  ResponseEntity.ok().body(departmentService.getDepartmentStatistics());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> getByDeptId(@PathVariable("id") Long departmentId){
        return ResponseEntity.ok().body(departmentService.findById(departmentId));
    }

}
