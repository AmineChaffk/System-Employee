package com.system_employee.employee.Repo;

import com.system_employee.employee.Entity.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveRepo extends JpaRepository<LeaveRequest, Integer> {
    List<LeaveRepo> findAllEmployeeById(Integer id);
}
