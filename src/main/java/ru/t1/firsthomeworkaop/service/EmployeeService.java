package ru.t1.firsthomeworkaop.service;

import org.springframework.transaction.annotation.Transactional;
import ru.t1.firsthomeworkaop.annotation.TrackTime;
import ru.t1.firsthomeworkaop.dto.EmployeeRequestDto;
import ru.t1.firsthomeworkaop.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    @Transactional
    Employee createEmployee(EmployeeRequestDto employeeRequestDto);
}
