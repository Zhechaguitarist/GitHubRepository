package com.fourth.fourthproject.controller;

import com.fourth.fourthproject.entity.Organization;
import com.fourth.fourthproject.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @PostMapping("/create")
    private Long create(@RequestBody Organization organization) {
        return organizationService.create(organization);
    }

    @GetMapping("/read")
    private List<Organization> read() {
        return organizationService.read();
    }

    @PutMapping("/update/{id}")
    private List<Organization> update(@PathVariable(name = "id") Long id, @RequestBody Organization organization) {
        return organizationService.update(id, organization);
    }

    @PutMapping("/delete/{id}")
    private List<Organization> delete(@PathVariable(name = "id") Long id) {
        return organizationService.delete(id);
    }

}