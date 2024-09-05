package com.example.employee_management.repository;

import com.example.employee_management.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT e FROM Employee e WHERE YEAR(e.hireDate) = :year AND e.department = :department")
    List<Employee> findByHireYearAndDepartment(@Param("year") int year, @Param("department") String department);
}
