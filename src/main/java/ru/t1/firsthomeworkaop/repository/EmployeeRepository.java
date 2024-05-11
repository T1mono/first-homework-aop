package ru.t1.firsthomeworkaop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.t1.firsthomeworkaop.model.Employee;

/**
 * Репозиторий для получения записей из my_db.employees.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
