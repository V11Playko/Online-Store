package com.playko.store.domain.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder(toBuilder = true)
public class InvoiceModel {
    private Long id;
    private String number;
    private String description;
    private Long customerId;
    private LocalDate createAt;
    private String state;
    private List<ItemModel> items;
}
