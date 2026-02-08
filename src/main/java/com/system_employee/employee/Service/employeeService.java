package com.system_employee.employee.Service;

import com.system_employee.employee.Dtos.CreateEmployee;
import com.system_employee.employee.Dtos.UpdateEmployee;
import com.system_employee.employee.Entity.Department;
import com.system_employee.employee.Entity.Employee;
import com.system_employee.employee.Repo.departmentRepo;
import com.system_employee.employee.Repo.employeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class employeeService {

    @Autowired
    private employeeRepo employeeRepo;


    @Autowired
    private departmentRepo departmentRepo;


    public boolean checkEmployee(Integer id) {
        return !employeeRepo.existsById(id);
    }

    public List<Employee> AllEmployee() {
        return employeeRepo.findAll();
    }

    public Employee EmployeeById(Integer id) {
        return employeeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee Id = " + id + " is Not Found"));
    }

    public Employee CreateOne(CreateEmployee EmployeeCreate) {
        Employee employee = new Employee();

        Department d = departmentRepo.findById(EmployeeCreate.departmentId())
                .orElseThrow(() -> new RuntimeException("Department Id = " + EmployeeCreate.departmentId() + " is Not Found"));


        employee.setPhone(EmployeeCreate.phone());
        employee.setFirstname(EmployeeCreate.firstname());
        employee.setPosition(EmployeeCreate.position());
        employee.setLastname(EmployeeCreate.lastname());
        employee.setEmail(EmployeeCreate.email());
        employee.setDescription(EmployeeCreate.description());
        employee.setDepartment(d);


        return employeeRepo.save(employee);
    }


    public void deleteOneEmployee(Integer id) {
        if (!checkEmployee(id))
            throw new RuntimeException("Employee Id = " + id + " is Not Found");
        employeeRepo.deleteById(id);
    }


    public Employee update(Integer id, UpdateEmployee employeeUpdate) {
        Employee currentEmployee = employeeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee with id = " + id + " is Not Found"));

        currentEmployee.setFirstname(employeeUpdate.firstname());
        currentEmployee.setLastname(employeeUpdate.lastname());
        currentEmployee.setPosition(employeeUpdate.position());
        currentEmployee.setPhone(employeeUpdate.phone());
        currentEmployee.setDescription(employeeUpdate.description());
        return employeeRepo.save(currentEmployee);
    }
}