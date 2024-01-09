package com.DEI_READY.DEI_EMPLOYEE.repository;

import com.DEI_READY.DEI_EMPLOYEE.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface OrganizationRepository {

    @Repository
    public interface OrganizationModelRepository extends JpaRepository<Organization, String >{

    }
}
