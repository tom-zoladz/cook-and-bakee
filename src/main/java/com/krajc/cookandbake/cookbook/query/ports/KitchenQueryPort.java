package com.krajc.cookandbake.cookbook.query.ports;

import com.krajc.cookandbake.cookbook.query.domain.model.KitchenView;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface KitchenQueryPort {
    List<KitchenView> findAll();
    Optional<KitchenView> findById(UUID id);
}
