package com.DEI_READY.DEI_EMPLOYEE.controller;

import com.DEI_READY.DEI_EMPLOYEE.entity.Organization;
import com.DEI_READY.DEI_EMPLOYEE.model.OrganizationModel;
import com.DEI_READY.DEI_EMPLOYEE.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @PostMapping
    public OrganizationModel createOrganizationModel(@RequestBody OrganizationModel organizationModel) {
        return organizationService.createOrganizationModel(organizationModel);

    }

    @GetMapping("/{org_id}")
    public ResponseEntity<OrganizationModel> getOrganizationModel(@PathVariable String org_id) {
        OrganizationModel organizationModel = new OrganizationModel();
        organizationModel = organizationService.getOrganizationModelByorg_id(org_id);
        return Organization.ok(organizationModel);
    }

    @DeleteMapping("/{emp_id}")
    public ResponseEntity<Map<String, Boolean>> deleteOrganizationModel(@PathVariable String org_id) {
        boolean deleted = false;

        deleted = organizationService.deleteOrganizationModel(org_id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", deleted);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{org_id}")
    public ResponseEntity<OrganizationModel> updateOrganizationModel(@PathVariable String id, @RequestBody OrganizationModel organizationModel) {
        organizationModel = organizationService.updateOrganizationModel(org_id, organizationModel);

        return ResponseEntity.ok(organizationModel);
    }

    @GetMapping
    public List<OrganizationModel> getAllOrganizationModel() {

        return organizationService.getAllOrganizationModels();
    }



}
