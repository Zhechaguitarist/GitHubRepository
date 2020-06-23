package com.fourth.fourthproject.service;

import com.fourth.fourthproject.entity.Organization;
import com.fourth.fourthproject.entity.TradeObject;
import com.fourth.fourthproject.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    public OrganizationRepository organizationRepository;

    @Override
    public Long create(Organization organization) {
        return organizationRepository.create(organization);
    }

    @Override
    public List<Organization> read() {
        return organizationRepository.read();
    }

    @Override
    public Organization readById(Long id) {
        return organizationRepository.readById(id);
    }

    @Override
    public List<Organization> update(Long id, Organization organization) {
        organizationRepository.update(id, organization);
        return organizationRepository.read();
    }

    @Override
    public List<Organization> delete(Long id) {
        organizationRepository.delete(id);
        return organizationRepository.read();
    }
}
