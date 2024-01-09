package com.DEI_READY.DEI_EMPLOYEE.controller;

import com.DEI_READY.DEI_EMPLOYEE.entity.Employee;
import com.DEI_READY.DEI_EMPLOYEE.model.EmployeeModel;
import com.DEI_READY.DEI_EMPLOYEE.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.HashMap;

public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public EmployeeModel createEmployeeModel(@RequestBody EmployeeModel employeeModel) {
        return employeeService.createEmployeeModel(employeeModel);

    }

    @GetMapping("/{employee_id}")
    public ResponseEntity<EmployeeModel> getEmployeeModel(@PathVariable String employee_id) {
        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel = employeeService.getEmployeeModelByemployee_id(employee_id);
        return Employee.ok(employeeModel);
    }

    @DeleteMapping("/{employee_id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployeeModel(@PathVariable String employee_id) {
        boolean deleted = false;

        deleted = employeeService.deleteEmployeeModel(employee_id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", deleted);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{employee_id}")
    public ResponseEntity<EmployeeModel> updateEmployeeModel(@PathVariable String id, @RequestBody EmployeeModel employeeModel){
        employeeModel = employeeService.updateEmployeeModel(employee_id, employeeModel);

        return ResponseEntity.ok(employeeModel);
    }

    @GetMapping
    public List<EmployeeModel> getAllEmployeeModels(){

        return employeeService.getAllEmployeeModels();
    }
}
