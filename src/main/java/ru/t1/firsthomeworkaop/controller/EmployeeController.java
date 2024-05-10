package ru.t1.firsthomeworkaop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.t1.firsthomeworkaop.dto.EmployeeRequestDto;
import ru.t1.firsthomeworkaop.model.Employee;
import ru.t1.firsthomeworkaop.service.EmployeeService;

import java.util.List;

/**
 * Контроллер для работы со справочниками.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    @PostMapping("/add-employee")
    public Employee createEmployee(@RequestBody EmployeeRequestDto employeeRequestDto) {
       return employeeService.createEmployee(employeeRequestDto);
    }
}
