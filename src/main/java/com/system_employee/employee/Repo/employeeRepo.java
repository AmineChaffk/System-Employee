package com.system_employee.employee.Repo;

import com.system_employee.employee.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface employeeRepo extends JpaRepository<Employee, Integer> {
    Employee findEmployeeById(Integer i);
}