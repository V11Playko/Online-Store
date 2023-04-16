package com.playko.store.domain.model;

import com.playko.store.domain.feign.Product;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Transient;

@Data
@Builder(toBuilder = true)
public class ItemModel {
    private Long idItem;
    private Double quantityItem;
    private Double priceItem;
    private Long productId;
    private Double subTotal;
    @Transient
    private Product product;
}
