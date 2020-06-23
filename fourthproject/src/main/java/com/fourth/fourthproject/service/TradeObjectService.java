package com.fourth.fourthproject.service;

import com.fourth.fourthproject.entity.Organization;
import com.fourth.fourthproject.entity.TradeObject;

import java.util.List;

public interface TradeObjectService {
    Long create(TradeObject tradeObject);

    List<TradeObject> read();

    List<TradeObject> update(Long id, TradeObject tradeObject);

    List<TradeObject> delete(Long id);
}
