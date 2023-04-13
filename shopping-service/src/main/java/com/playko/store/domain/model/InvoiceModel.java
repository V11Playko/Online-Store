package com.playko.store.domain.model;

import com.playko.store.domain.feign.Customer;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Transient;
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
    @Transient
    private Customer customer;
    private List<ItemModel> items;
}
