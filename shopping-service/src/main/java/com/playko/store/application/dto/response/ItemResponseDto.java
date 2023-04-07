package com.playko.store.application.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemResponseDto {
    private Long idItem;
    private Double quantityItem;
    private Double priceItem;
    private Long productId;
}
