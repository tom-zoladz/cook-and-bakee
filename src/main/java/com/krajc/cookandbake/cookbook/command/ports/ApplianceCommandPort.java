package com.krajc.cookandbake.cookbook.command.ports;

import com.krajc.cookandbake.cookbook.command.domain.model.Appliance;

public interface ApplianceCommandPort {
    Appliance save(Appliance appliance);
}
