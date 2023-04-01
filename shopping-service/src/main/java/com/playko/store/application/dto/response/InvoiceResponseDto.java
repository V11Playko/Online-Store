package com.playko.store.application.dto.response;

import com.playko.store.domain.model.ItemModel;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class InvoiceResponseDto {
    private Long id;
    private String number;
    private String description;
    private Long customerId;
    private Date createAt;
    private String state;
    private List<ItemModel> item;
}
