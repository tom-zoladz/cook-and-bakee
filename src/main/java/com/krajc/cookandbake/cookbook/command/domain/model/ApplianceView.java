package com.krajc.cookandbake.cookbook.command.domain.model;

import com.krajc.cookandbake.cookbook.infrastructure.jpa.model.ApplianceJpa;

public record ApplianceView(
        Long id,
        String name
) {
    public static ApplianceView getFromJpa(ApplianceJpa applianceJpa) {
        return new ApplianceView(applianceJpa.getId(), applianceJpa.getName());
    }

    public ApplianceJpa toJpa() {
        return new ApplianceJpa(this.name);
    }
}
