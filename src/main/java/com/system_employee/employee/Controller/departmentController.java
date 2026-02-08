package com.system_employee.employee.Controller;


import com.system_employee.employee.Dtos.CreateDepartment;
import com.system_employee.employee.Dtos.UpdateDepartment;
import com.system_employee.employee.Entity.Department;
import com.system_employee.employee.Service.departmentService;
import com.system_employee.employee.Shared.GlobalResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/department")
public class departmentController {
    @Autowired
    private departmentService departmentService;

    @GetMapping
    public ResponseEntity<GlobalResponse<List<Department>>> AllDepartment() {
        return new ResponseEntity<>(new GlobalResponse<>(departmentService.findAll()), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<GlobalResponse<Department>> DepartmentById(@PathVariable Integer id) {
        return new ResponseEntity<>(new GlobalResponse<>(departmentService.findOne(id)), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<GlobalResponse<Department>> CreateOne(@RequestBody @Valid CreateDepartment department) {
        return new ResponseEntity<>(new GlobalResponse<>(departmentService.CreateOne(department)), HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeleteOne(@PathVariable Integer id) {
        departmentService.deleteOne(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOne(
            @PathVariable Integer id,
            @RequestBody @Valid UpdateDepartment department
    ) {
        return new ResponseEntity<>(new GlobalResponse<>(departmentService.update(id, department)), HttpStatus.OK);
    }

}
