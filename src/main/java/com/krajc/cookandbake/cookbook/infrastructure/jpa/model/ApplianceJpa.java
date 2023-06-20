package com.krajc.cookandbake.cookbook.infrastructure.jpa.model;

import jakarta.persistence.*;


@Entity
@Table
public class ApplianceJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applianceId;
    private String name;

    public ApplianceJpa() {
    }

    public ApplianceJpa(String name) {
        this.name = name;
    }

    public Long getApplianceId() {
        return applianceId;
    }

    public void setApplianceId(Long applianceId) {
        this.applianceId = applianceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
