package com.playko.store.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.playko.store.domain.feign.Product;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

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
