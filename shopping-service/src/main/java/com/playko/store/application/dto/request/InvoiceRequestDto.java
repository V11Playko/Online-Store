package com.playko.store.application.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class InvoiceRequestDto {
    private Long id;
    private String number;
    private String description;
    private Long customerId;
    private Date createAt;
    private String state;

    // Invoice Item
    private Long idItem;
    private Double quantityItem;
    private Double priceItem;
    private Long productId;
}
