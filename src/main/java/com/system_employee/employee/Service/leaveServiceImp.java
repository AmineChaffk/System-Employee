package com.system_employee.employee.Service;


import com.system_employee.employee.Abstarct.Leave;
import com.system_employee.employee.Dtos.CreateLeave;
import com.system_employee.employee.Entity.Employee;
import com.system_employee.employee.Entity.LeaveRequest;
import com.system_employee.employee.Repo.LeaveRepo;
import com.system_employee.employee.Repo.employeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class leaveServiceImp implements Leave {

    @Autowired
    private LeaveRepo LeaveRepo;

    @Autowired
    private employeeRepo employeeRepo;


    public LeaveRequest createOne(CreateLeave CreateLeave, Integer id) {
        LeaveRequest Leave = new LeaveRequest();
        Employee e1 = employeeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee with id = " + id + " is Not Found"));
        Leave.setStatus("PENDING");
        Leave.setReason(CreateLeave.reason());
        Leave.setEndDate(CreateLeave.endDate());
        Leave.setStartDate(CreateLeave.startDate());
        Leave.setEmployee(e1);
        return LeaveRepo.save(Leave);
    }

    @Override
    public List<LeaveRequest> findAllEmployeeById(Integer id) {
        return List.of();
    }
}
