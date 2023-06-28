package com.krajc.cookandbake.cookbook.infrastructure.jpa.adapters;

import com.krajc.cookandbake.cookbook.command.domain.model.Kitchen;
import com.krajc.cookandbake.cookbook.infrastructure.jpa.model.KitchenJpa;
import com.krajc.cookandbake.cookbook.infrastructure.jpa.repository.KitchenJpaRepository;
import com.krajc.cookandbake.cookbook.query.domain.model.KitchenView;
import com.krajc.cookandbake.cookbook.query.ports.KitchenQueryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

@Component
public class KitchenRepositoryAdapter implements KitchenQueryPort {
    private final KitchenJpaRepository kitchenRepository;

    public KitchenRepositoryAdapter(KitchenJpaRepository kitchenRepository) {
        this.kitchenRepository = kitchenRepository;
    }

    @Override
    public List<KitchenView> findAll() {
        return kitchenRepository.findAll().stream()
                .map(kitchenViewMapper)
                .toList();
    }

    @Override
    public Optional<KitchenView> findById(UUID id) {
        return kitchenRepository.findById(id).map(kitchenViewMapper);
    }

    private final Function<KitchenJpa, Kitchen> kitchenMapper = kitchenJpa ->
            new Kitchen(
                    kitchenJpa.getId(),
                    kitchenJpa.getName(),
                    kitchenJpa.getDescription(),
                    kitchenJpa.getAuthor().getId()
            );

    private final Function<KitchenJpa, KitchenView> kitchenViewMapper = kitchenJpa ->
            new KitchenView(
                    kitchenJpa.getId(),
                    kitchenJpa.getName(),
                    kitchenJpa.getDescription(),
                    kitchenJpa.getAuthor().getId()
            );
}
