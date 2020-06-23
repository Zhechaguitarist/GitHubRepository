package com.fourth.fourthproject.service;

import com.fourth.fourthproject.entity.TradeObject;
import com.fourth.fourthproject.repository.TradeObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeObjectServiceImpl implements TradeObjectService {

    @Autowired
    TradeObjectRepository tradeObjectRepository;

    @Override
    public Long create(TradeObject tradeObject) {
        return tradeObjectRepository.create(tradeObject);
    }

    @Override
    public List<TradeObject> read() {
        return tradeObjectRepository.read();
    }

    @Override
    public TradeObject readById(Long id) {
        return tradeObjectRepository.readById(id);
    }

    @Override
    public List<TradeObject> update(Long id, TradeObject tradeObject) {
        tradeObjectRepository.update(id, tradeObject);
        return tradeObjectRepository.read();
    }

    @Override
    public List<TradeObject> delete(Long id) {
        tradeObjectRepository.delete(id);
        return tradeObjectRepository.read();
    }
}
