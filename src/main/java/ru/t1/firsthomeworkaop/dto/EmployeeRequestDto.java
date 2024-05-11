package ru.t1.firsthomeworkaop.dto;

import lombok.Data;

/**
 * Запись справочника my_db.employees из базы данных.
 */
@Data
public class EmployeeRequestDto {
    private String name;
    private String surname;
    private String department;
    private int salary;
}
