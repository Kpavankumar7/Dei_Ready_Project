package com.DEI_READY.DEI_EMPLOYEE.serviceImplementation;


import com.DEI_READY.DEI_EMPLOYEE.entity.Organization;
import com.DEI_READY.DEI_EMPLOYEE.model.OrganizationModel;
import com.DEI_READY.DEI_EMPLOYEE.repository.OrganizationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.ImageProducer;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrganizationServiceImplementation {

    @Autowired
    private OrganizationRepository organizationRepository;
    private OrganizationRepository ;

    @Override
    public OrganizationModel createOrganizationModel(OrganizationModel organizationModel){
        Organization organization = new Organization();

        BeanUtils.copyProperties(organizationModel, organization);
        organizationRepository.save(organization);
        return organizationModel;
    }

    @Override
    public OrganizationModel getOrganizationModelByorg_id(String org_id){
        Organization organization = organizationRepository.findByOrg_id(org_id).get();
        OrganizationModel organizationModel = new OrganizationModel();
        BeanUtils.copyProperties(organization, organization);
        return organizationModel;
    }

    @Override
    public boolean deleteOrganizationModel(String org_id) {
        Organization organization = organizationRepository.findByOrg_id(org_id).get();
        organizationRepository.delete(organization);
        return true;
    }

    @Override
    public OrganizationModel updateOrganizationModel(String org_id, OrganizationModel organizationModel) {
        Organization organization = organizationRepository.findByorg_id(org_id).get();
        organization.setOrg_id(OrganizationModel.getOrg_id());
        organization.setOrg_code(OrganizationModel.getOrg_code());
        organization.setOrg_name(OrganizationModel.getOrg_name());
        organization.setOrg_desc(OrganizationModel.getOrg_desc());
        organization.setLast_updated_by(OrganizationModel.getLast_updated_by());
        organization.setLast_updated_timestamp(OrganizationModel.getLast_updated_timestamp());
        organization.setStreet(OrganizationModel.getStreet());
        organization.setCity(OrganizationModel.getCity());
        organization.setZip_code(OrganizationModel.getZip_code());
        organization.setState(OrganizationModel.getstate());
        organization.setCountry(OrganizationModel.getCountry());
        organization.setPhone(OrganizationModel.getPhone());
        organization.setEmail(OrganizationModel.getEmail());
        organization.setUrl(OrganizationModel.Url());

        organizationRepository.save(organization);
        return organizationModel;


    }

    @Override
    public List<OrganizationModel> getAllOrganizations(){
        List<Organization> organizationEntities = organizationRepository.findAll();
        List<OrganizationModel> organizations = organizationEntities
                .stream() Stream<Organization>
                .map(res - > new OrganizationModel(
                        res.getOrg_id(),
                        res.getOrg_code(),
                        res.getOrg_name(),
                        res.getOrg_desc(),
                        res.getLast_updated_by(),
                        res.getLast_updated_timestamp(),
                        res.getStreet(),
                        res.getCity(),
                        res.getZip_code(),
                        res.getState(),
                        res.getCountry(),
                        res.getPhone(),
                        res.getEmail(),
                        res.setUrl())) Stream<R>
                .collect(Collectors.toList());
        return organizations;

        )


    }


}
