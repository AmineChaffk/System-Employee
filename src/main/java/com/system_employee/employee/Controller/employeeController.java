package com.system_employee.employee.Controller;

import com.system_employee.employee.Dtos.CreateEmployee;
import com.system_employee.employee.Dtos.CreateLeave;
import com.system_employee.employee.Dtos.UpdateEmployee;
import com.system_employee.employee.Entity.Employee;
import com.system_employee.employee.Entity.LeaveRequest;
import com.system_employee.employee.Service.employeeService;
import com.system_employee.employee.Service.leaveServiceImp;
import com.system_employee.employee.Shared.GlobalResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class employeeController {


    @Autowired
    private employeeService dataService;

    @Autowired
    private leaveServiceImp leaveServiceImp;


    @GetMapping
    public ResponseEntity<GlobalResponse<List<Employee>>> AllEmployee() {
        return new ResponseEntity<>(new GlobalResponse<>(dataService.AllEmployee()), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<GlobalResponse<Employee>> EmployeeById(@PathVariable Integer id) {
        return new ResponseEntity<>(new GlobalResponse<>(dataService.EmployeeById(id)), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<GlobalResponse<Employee>> CreateOneEmployee(@RequestBody @Valid CreateEmployee employee) {
        return new ResponseEntity<>(new GlobalResponse<>(dataService.CreateOne(employee)), HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeleteOne(@PathVariable Integer id) {
        dataService.deleteOneEmployee(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOne(
            @PathVariable Integer id,
            @RequestBody @Valid UpdateEmployee employee
    ) {
        return new ResponseEntity<>(new GlobalResponse<>(dataService.update(id, employee)), HttpStatus.OK);
    }


    @PostMapping("/{EmployeeId}/LeaveRequest")
    public ResponseEntity<GlobalResponse<LeaveRequest>> CreateOneEmployee(
            @RequestBody @Valid CreateLeave CreateLeave,
            @PathVariable Integer EmployeeId
    ) {
        return new ResponseEntity<>(new GlobalResponse<>(leaveServiceImp.createOne(CreateLeave, EmployeeId)), HttpStatus.CREATED);
    }

}
