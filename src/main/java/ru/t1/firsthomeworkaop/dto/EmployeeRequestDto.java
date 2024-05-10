package ru.t1.firsthomeworkaop.dto;

import lombok.Data;

@Data
public class EmployeeRequestDto {
    private String name;
    private String surname;
    private String department;
    private int salary;
}
