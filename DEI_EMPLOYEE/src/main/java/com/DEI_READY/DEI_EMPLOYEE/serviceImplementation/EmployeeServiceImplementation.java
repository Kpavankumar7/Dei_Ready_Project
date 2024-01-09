package com.DEI_READY.DEI_EMPLOYEE.serviceImplementation;

import com.DEI_READY.DEI_EMPLOYEE.entity.Employee;
import com.DEI_READY.DEI_EMPLOYEE.model.EmployeeModel;
import com.DEI_READY.DEI_EMPLOYEE.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class EmployeeServiceImplementation {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeModel createEmployeeModel(EmployeeModel employeeModel) {
        Employee employee = new Employee();

        BeanUtils.copyProperties(employeeModel, employee);
        employeeRepository.save(employee);
        return employeeModel;

    }

    @Override
    public EmployeeModel getEmployeeModelByEmployee_id(String employee_id) {
        Employee employee = employeeRepository.findByEmployee_id(employee_id).get();
        EmployeeModel employeeModel = new EmployeeModel();
        BeanUtils.copyProperties(employee, employee);
        return employeeModel;

    }

    @Override
    public boolean deleteEmployeeModel(String employee_id) {
        Employee employee = employeeRepository.findByEmployee_id(employee_id).get();
        employeeRepository.delete(employee);
        return true;
    }

    @Override
    public EmployeeModel updateEmployeeModel(String employee_id, EmployeeModel employeeModel) {
        Employee employee = employeeRepository.findByemployee_id(employee_id).get();
        employee.setEmployee_id(employeeModel.getEmployee_id());
        employee.setDiv_id(employeeModel.getDiv_id());
        employee.setEmployee_name(employeeModel.getEmployee_name());
        employee.setEmployee_email(employeeModel.getEmployee_email());
        employee.setEmployee_phone(employeeModel.getEmployee_phone());
        employee.setOrg_city(employeeModel.getOrg_city());
        employee.setOrg_state(employeeModel.getOrg_state());
        employee.setOrg_country(employeeModel.getOrg_country());
        employee.setRpt_manager_id(employeeModel.getOpt_manager_id());

        employeeRepository.save(employee);
        return employeeModel;
    }

    @Override
    public List<EmployeeModel> getAllEmployees() {
        List<Employee> employeeEntities = employeeRepository.findAll();
        List<EmployeeModel> employees = employeeEntities
                .stream()
                .map(res - > new EmployeeModel(
                        res.getEmployee_id(),
                        res.getDiv_id(),
                        res.getEmployee_name(),
                        res.getEmployee_email(),
                        res.getEmployee_phone(),
                        res.getOrg_city(),
                        res.getOrg_state(),
                        res.getOrg_country(),
                        res.getRpt_manager_id()))
                .collect(Collectors.toList());
        return employees;
                )
    }


}
