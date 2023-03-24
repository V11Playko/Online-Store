package com.playko.store.domain.model;

public class CustomerModel {
    private Long id;
    private String dni;
    private String firstName;
    private String lastName;
    private String email;
    private String photoUrl;
    private String state;
    private RegionModel regionModel;


    public CustomerModel(Long id, String dni, String firstName, String lastName, String email, String photoUrl, RegionModel regionModel, String state) {
        this.id = id;
        this.dni = dni;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.photoUrl = photoUrl;
        this.regionModel = regionModel;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public RegionModel getRegion() {
        return regionModel;
    }

    public void setRegion(RegionModel regionModel) {
        this.regionModel = regionModel;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
