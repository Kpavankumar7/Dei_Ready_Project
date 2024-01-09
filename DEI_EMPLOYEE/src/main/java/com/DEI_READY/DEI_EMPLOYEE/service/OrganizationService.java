package com.DEI_READY.DEI_EMPLOYEE.service;

import com.DEI_READY.DEI_EMPLOYEE.entity.Organization;
import com.DEI_READY.DEI_EMPLOYEE.model.OrganizationModel;

import java.util.List;

public interface OrganizationService {

    public OrganizationModel createOrganization(OrganizationModel organizationModel);

    public OrganizationModel getOrganizationModelByorg_id(String org_id);

    public boolean deleteOrganizationModel(String org_id);

    public Organization updateOrganizationModel(String org_id, OrganizationModel organizationModel);

    public List<OrganizationModel> getAllOrganizationModels();
}
