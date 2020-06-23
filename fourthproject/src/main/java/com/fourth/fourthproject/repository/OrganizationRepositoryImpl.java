package com.fourth.fourthproject.repository;

import com.fourth.fourthproject.entity.Organization;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
@AllArgsConstructor
public class OrganizationRepositoryImpl implements OrganizationRepository {

    public JdbcTemplate jdbcTemplate;

    @Override
    public Long create(Organization organization) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            final PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO organization (name, inn) VALUES (?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            int idx = 0;
            ps.setString(++idx, organization.getName());
            ps.setLong(++idx, organization.getInn());
            return ps;
        }, keyHolder);
        return (Long) Objects.requireNonNull(keyHolder.getKeys()).get("id");
    }

    @Override
    public List<Organization> read() {
        return jdbcTemplate.query("SELECT * FROM organization", this::extractOrganization);
    }

    @Override
    public void update(Long id, Organization organization) {
        jdbcTemplate.update("UPDATE organization SET name = ?, inn = ? WHERE id = ?", ps -> {
            int idx = 0;
            ps.setString(++idx, organization.getName());
            ps.setLong(++idx, organization.getInn());
            ps.setLong(++idx, id);
        });
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM organization WHERE id = ?", ps -> {
            int idx = 0;
            ps.setLong(++idx, id);
        });
    }



    /*@Override
    public List<Organization> update(Long id, Organization organization) {
        return jdbcTemplate.query("UPDATE organization SET name = ?, inn = ? WHERE id = ?" +
                "SELECT * FROM organization", ps -> {
            int idx = 0;
            ps.setString(++idx, organization.getName());
            ps.setLong(++idx, organization.getInn());
            ps.setLong(++idx, id);
        }, this::extractUser);
    }*/

    private List<Organization> extractOrganization(ResultSet rs) throws SQLException {
        List<Organization> organizations = new ArrayList<>();
        while (rs.next()) {
            Organization organization = new Organization();
            organization.setId(rs.getLong("id"));
            organization.setName(rs.getString("name"));
            organization.setInn(rs.getLong("inn"));
            organizations.add(organization);
        }
        return organizations;
    }
}

