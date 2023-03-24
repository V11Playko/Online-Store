package com.playko.store.domain.model;

public class RegionModel {
    private Long idRegion;
    private String nameRegion;

    public RegionModel(Long idRegion, String nameRegion) {
        this.idRegion = idRegion;
        this.nameRegion = nameRegion;
    }

    public Long getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Long idRegion) {
        this.idRegion = idRegion;
    }

    public String getNameRegion() {
        return nameRegion;
    }

    public void setNameRegion(String nameRegion) {
        this.nameRegion = nameRegion;
    }
}
