package com.fourth.fourthproject.controller;

import com.fourth.fourthproject.entity.Organization;
import com.fourth.fourthproject.entity.TradeObject;
import com.fourth.fourthproject.service.TradeObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("trade-object")
public class TradeObjectController {

    @Autowired
    private TradeObjectService tradeObjectService;

    @PostMapping("/create")
    private Long create(@RequestBody TradeObject tradeObject) {
        return tradeObjectService.create(tradeObject);
    }

    @GetMapping("/read")
    private List<TradeObject> read() {
        return tradeObjectService.read();
    }

    @PutMapping("/update/{id}")
    private List<TradeObject> update(@PathVariable(name = "id") Long id, @RequestBody TradeObject tradeObject) {
        return tradeObjectService.update(id, tradeObject);
    }

    @PutMapping("/delete/{id}")
    private List<TradeObject> delete(@PathVariable(name = "id") Long id) {
        return tradeObjectService.delete(id);
    }
}
