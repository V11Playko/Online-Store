package com.playko.store.application.dto.request;

import com.playko.store.domain.model.ItemModel;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder(toBuilder = true)
public class UpdateItemRequestDto {
    private Long id;

    private Double quantity;

    private Double price;

    private Long productId;

    public static List<ItemModel> toItemModelList(List<UpdateItemRequestDto> itemRequestList) {
        List<ItemModel> itemModelList = new ArrayList<>();
        for (UpdateItemRequestDto itemRequest : itemRequestList) {
            itemModelList.add(itemRequest.toItemModel());
        }
        return itemModelList;
    }

    public ItemModel toItemModel() {
        return ItemModel.builder()
                .idItem(id)
                .quantityItem(quantity)
                .priceItem(price)
                .productId(productId)
                .subTotal(quantity * price)
                .build();
    }
}
