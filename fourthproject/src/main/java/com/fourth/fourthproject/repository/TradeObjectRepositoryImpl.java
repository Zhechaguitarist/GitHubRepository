package com.fourth.fourthproject.repository;

import com.fourth.fourthproject.entity.Organization;
import com.fourth.fourthproject.entity.TradeObject;
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
public class TradeObjectRepositoryImpl implements TradeObjectRepository {

    public JdbcTemplate jdbcTemplate;

    @Override
    public Long create(TradeObject tradeObject) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            final PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO tradeobject (name, inn, organization_id) VALUES (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            int idx = 0;
            ps.setString(++idx, tradeObject.getName());
            ps.setLong(++idx, tradeObject.getInn());
            ps.setLong(++idx, tradeObject.getOrganization_id());
            return ps;
        }, keyHolder);
        return (Long) Objects.requireNonNull(keyHolder.getKeys()).get("id");
    }

    @Override
    public List<TradeObject> read() {
        return jdbcTemplate.query("SELECT * FROM tradeobject", this::extractTradeObject);
    }

    @Override
    public void update(Long id, TradeObject tradeObject) {
        jdbcTemplate.update("UPDATE tradeobject SET name = ?, inn = ?, organization_id = ? WHERE id = ?", ps -> {
            int idx = 0;
            ps.setString(++idx, tradeObject.getName());
            ps.setLong(++idx, tradeObject.getInn());
            ps.setLong(++idx, tradeObject.getOrganization_id());
            ps.setLong(++idx, id);
        });
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM tradeobject WHERE id = ?", ps -> {
            int idx = 0;
            ps.setLong(++idx, id);
        });
    }

    private List<TradeObject> extractTradeObject(ResultSet rs) throws SQLException {
        List<TradeObject> tradeObjects = new ArrayList<>();
        while (rs.next()) {
            TradeObject tradeObject = new TradeObject();
            tradeObject.setId(rs.getLong("id"));
            tradeObject.setName(rs.getString("name"));
            tradeObject.setInn(rs.getLong("inn"));
            tradeObjects.add(tradeObject);
        }
        return tradeObjects;
    }
}
