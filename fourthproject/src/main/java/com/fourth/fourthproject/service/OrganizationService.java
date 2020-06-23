package com.fourth.fourthproject.service;

import com.fourth.fourthproject.entity.Organization;

import java.util.List;

public interface OrganizationService {

    Long create(Organization organization);

    List<Organization> read();

    List<Organization> update(Long id, Organization organization);

    List<Organization> delete(Long id);
}
