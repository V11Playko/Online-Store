package com.playko.store.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class ItemModel {
    private Long idItem;
    private Double quantityItem;
    private Double priceItem;
    private Long productId;
    private Double subTotal;
}
