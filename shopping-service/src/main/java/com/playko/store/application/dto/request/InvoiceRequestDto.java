package com.playko.store.application.dto.request;

import com.playko.store.domain.model.InvoiceItemModel;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

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
    private Double price;
    private Long productId;
}
