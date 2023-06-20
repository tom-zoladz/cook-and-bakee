package com.krajc.cookandbake.cookbook.query.domain.model;

import com.krajc.cookandbake.cookbook.infrastructure.jpa.model.ApplianceJpa;

public record ApplianceView(
        Long applianceId,
        String name
) {
    public static ApplianceView getFromJpa(ApplianceJpa applianceJpa) {
        return new ApplianceView(applianceJpa.getApplianceId(), applianceJpa.getName());
    }

}
