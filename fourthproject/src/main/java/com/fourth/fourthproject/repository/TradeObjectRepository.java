package com.fourth.fourthproject.repository;

import com.fourth.fourthproject.entity.TradeObject;

import java.util.List;

public interface TradeObjectRepository {
    Long create(TradeObject tradeObject);

    List<TradeObject> read();

    TradeObject readById(Long id);

    void update(Long id, TradeObject tradeObject);

    void delete(Long id);
}
