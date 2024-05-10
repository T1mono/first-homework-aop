package ru.t1.firsthomeworkaop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.t1.firsthomeworkaop.annotation.TrackAsyncTime;
import ru.t1.firsthomeworkaop.annotation.TrackTime;
import ru.t1.firsthomeworkaop.dto.EmployeeRequestDto;
import ru.t1.firsthomeworkaop.model.Employee;
import ru.t1.firsthomeworkaop.repository.EmployeeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    @TrackTime
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    @TrackAsyncTime
    public Employee createEmployee(EmployeeRequestDto employeeRequestDto) {
        Employee employee = new Employee();
        employee.setName(employeeRequestDto.getName());
        employee.setSurname(employeeRequestDto.getSurname());
        employee.setDepartment(employeeRequestDto.getDepartment());
        employee.setSalary(employeeRequestDto.getSalary());

        return employeeRepository.save(employee);
    }
}
