package com.fourth.fourthproject.repository;

import com.fourth.fourthproject.entity.Organization;

import java.util.List;

public interface OrganizationRepository {

    Long create(Organization organization);

    List<Organization> read();

    Organization readById(Long id);

    void update(Long id, Organization organization);

    void delete(Long id);

}
