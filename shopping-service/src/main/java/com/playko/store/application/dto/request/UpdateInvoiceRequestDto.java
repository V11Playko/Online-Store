package com.playko.store.application.dto.request;

import com.playko.store.domain.model.InvoiceModel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class UpdateInvoiceRequestDto {
    private Long id;
    private String number;
    private String description;
    private Long customerId;
    private List<UpdateItemRequestDto> items;

    public InvoiceModel toInvoice() {
        return InvoiceModel.builder()
                .id(id)
                .number(number)
                .description(description)
                .customerId(customerId)
                .createAt(LocalDate.now())
                .state("CREATED")
                .build();
    }
}
