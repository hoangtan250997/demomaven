package com.example.demomaven.service.dto;

import com.example.demomaven.entity.Location;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DepartmentDto {
    private Long id;
    private String name;
    private Location location;

}
