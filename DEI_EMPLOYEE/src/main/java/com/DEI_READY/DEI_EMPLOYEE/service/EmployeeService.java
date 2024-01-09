package com.DEI_READY.DEI_EMPLOYEE.service;

import com.DEI_READY.DEI_EMPLOYEE.entity.Employee;
import com.DEI_READY.DEI_EMPLOYEE.model.EmployeeModel;

import java.awt.*;

public interface EmployeeService {

    public EmployeeModel createEmployeeModel(EmployeeModel employeeModel);

    public EmployeeModel getEmployeeModelByemployee_id(String employee_id);

    public boolean deleteEmployeeModel(String employee_id);

    public Employee updateEmployeeModel(String employee_id, EmployeeModel employeeModel);

    public List<EmployeeModel> getAllEmployeeModels();


}
