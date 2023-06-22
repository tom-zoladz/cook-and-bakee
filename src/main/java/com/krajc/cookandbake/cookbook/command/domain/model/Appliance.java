package com.krajc.cookandbake.cookbook.command.domain.model;

import com.krajc.cookandbake.cookbook.infrastructure.jpa.model.ApplianceJpa;

public record Appliance(
        Long id,
        String name
) {
    public static Appliance getFromJpa(ApplianceJpa applianceJpa) {
        return new Appliance(applianceJpa.getId(), applianceJpa.getName());
    }

    public ApplianceJpa toJpa() {
        return new ApplianceJpa(this.name);
    }
}
