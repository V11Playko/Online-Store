package com.playko.store.application.dto.request;

import com.playko.store.domain.model.InvoiceModel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class SaveInvoiceRequestDto {
    private String number;
    private String description;
    private Long customerId;
    private List<SaveItemRequestDto> items;

    public InvoiceModel toInvoiceModel() {
        return InvoiceModel.builder()
                .number(number)
                .description(description)
                .customerId(customerId)
                .createAt(LocalDate.now())
                .state("CREATED")
                .items(SaveItemRequestDto.toItemModelList(items))
                .build();
    }
}
