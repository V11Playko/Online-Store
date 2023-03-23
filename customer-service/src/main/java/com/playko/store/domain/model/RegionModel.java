package com.playko.store.domain.model;

public class RegionModel {
    private Long id;
    private String nameRegion;

    public RegionModel(Long id, String nameRegion) {
        this.id = id;
        this.nameRegion = nameRegion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameRegion() {
        return nameRegion;
    }

    public void setNameRegion(String nameRegion) {
        this.nameRegion = nameRegion;
    }
}
