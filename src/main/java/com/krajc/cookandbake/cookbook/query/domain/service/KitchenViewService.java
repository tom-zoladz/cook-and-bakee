package com.krajc.cookandbake.cookbook.query.domain.service;

import com.krajc.cookandbake.cookbook.query.domain.model.KitchenView;
import com.krajc.cookandbake.cookbook.query.ports.KitchenQueryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class KitchenViewService { //TODO exceptions
    KitchenQueryPort kitchenQueryPort;

    public KitchenViewService(KitchenQueryPort kitchenQueryPort) {
        this.kitchenQueryPort = kitchenQueryPort;
    }

    public List<KitchenView> findAll() {
        return kitchenQueryPort.findAll();
    }

    public KitchenView findById(String id) {
        return kitchenQueryPort.findById(UUID.fromString(id)).get();
    }
}
