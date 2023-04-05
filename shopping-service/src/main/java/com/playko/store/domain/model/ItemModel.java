package com.playko.store.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder(toBuilder = true)
public class ItemModel {
    private Long idItem;
    private Double quantityItem;
    private Double priceItem;
    private Long productId;
    @JsonIgnore
    private Double subTotal;
}
