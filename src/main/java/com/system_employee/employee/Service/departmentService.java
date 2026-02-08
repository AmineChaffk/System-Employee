package com.system_employee.employee.Service;


import com.system_employee.employee.Dtos.CreateDepartment;
import com.system_employee.employee.Dtos.UpdateDepartment;
import com.system_employee.employee.Entity.Department;
import com.system_employee.employee.Repo.departmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class departmentService {


    @Autowired
    private departmentRepo departmentRepo;


    public boolean checkDepartment(Integer id) {
        return !departmentRepo.existsById(id);
    }

    public Department findOne(Integer Id) {
        return departmentRepo.findById(Id)
                .orElseThrow(() -> new RuntimeException("Department Id = " + Id + " is Not Found"));
    }


    public List<Department> findAll() {
        return departmentRepo.findAll();
    }


    public Department CreateOne(CreateDepartment Department) {
        Department department = new Department();
        department.setName(Department.name());
        return departmentRepo.save(department);
    }


    public void deleteOne(Integer id) {
        departmentRepo.deleteById(id);
    }


    public Department update(
            Integer id,
            UpdateDepartment UpdateDepartment
    ) {
        Department currentDepartment = departmentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Department with id = " + id + " is Not Found"));
        currentDepartment.setName(UpdateDepartment.name());
        return departmentRepo.save(currentDepartment);
    }


}
