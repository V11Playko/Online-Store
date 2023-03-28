package com.playko.store.domain.model;

import java.util.Date;
import java.util.List;

public class InvoiceModel {
    private Long id;
    private String number;
    private String description;
    private Long customerId;
    private Date createAt;
    private String state;
    private List<InvoiceItemModel> items;
    public InvoiceModel(Long id, String number, String description, Long customerId, Date createAt, String state, List<InvoiceItemModel> items) {
        this.id = id;
        this.number = number;
        this.description = description;
        this.customerId = customerId;
        this.createAt = createAt;
        this.state = state;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<InvoiceItemModel> getItems() {
        return items;
    }

    public void setItems(List<InvoiceItemModel> items) {
        this.items = items;
    }
}
