package com.playko.store.domain.model;

public class InvoiceItemModel {
    private Long idItem;
    private Double quantityItem;
    private Double price;
    private Long productId;
    private Double subTotal;

    public InvoiceItemModel(Long idItem, Double quantityItem, Double price, Long productId, Double subTotal) {
        this.idItem = idItem;
        this.quantityItem = quantityItem;
        this.price = price;
        this.productId = productId;
        this.subTotal = subTotal;
    }

    public Long getIdItem() {
        return idItem;
    }

    public void setIdItem(Long idItem) {
        this.idItem = idItem;
    }

    public Double getQuantityItem() {
        return quantityItem;
    }

    public void setQuantityItem(Double quantityItem) {
        this.quantityItem = quantityItem;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Double getSubTotal() {
        if (this.price >0  && this.quantityItem >0 ){
            return this.quantityItem * this.price;
        }else {
            return (double) 0;
        }
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }
}
