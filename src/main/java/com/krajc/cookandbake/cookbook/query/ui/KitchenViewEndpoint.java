package com.krajc.cookandbake.cookbook.query.ui;

import com.krajc.cookandbake.cookbook.query.domain.model.KitchenView;
import com.krajc.cookandbake.cookbook.query.domain.service.KitchenViewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app/kitchens")
public class KitchenViewEndpoint {
    private KitchenViewService kitchenViewService;

    public KitchenViewEndpoint(KitchenViewService kitchenViewService) {
        this.kitchenViewService = kitchenViewService;
    }

    @GetMapping
    public ResponseEntity<List<KitchenView>> getAllKitchens() {
        return ResponseEntity.ok(kitchenViewService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<KitchenView> getKitchenViewById(@PathVariable String id) {
        return ResponseEntity.ok(kitchenViewService.findById(id));
    }

}
