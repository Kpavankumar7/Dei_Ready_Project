package com.DEI_READY.DEI_EMPLOYEE.repository;

import com.DEI_READY.DEI_EMPLOYEE.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EmployeeRepository {

    @Repository
    public interface EmployeeModelRepository extends JpaRepository<Employee, String> {

    }

}
