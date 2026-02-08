package com.system_employee.employee.Repo;

import com.system_employee.employee.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface departmentRepo extends JpaRepository<Department, Integer> {
}
