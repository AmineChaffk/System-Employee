package com.system_employee.employee.Abstarct;

import com.system_employee.employee.Dtos.CreateLeave;
import com.system_employee.employee.Entity.LeaveRequest;

import java.util.List;

public interface Leave {
    LeaveRequest createOne(CreateLeave CreateLeave, Integer id);

    List<LeaveRequest> findAllEmployeeById(Integer id);
}
