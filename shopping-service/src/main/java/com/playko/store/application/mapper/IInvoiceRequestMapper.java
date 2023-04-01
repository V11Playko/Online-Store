package com.playko.store.application.mapper;

import com.playko.store.application.dto.request.InvoiceRequestDto;
import com.playko.store.domain.model.InvoiceModel;
import com.playko.store.domain.model.ItemModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IInvoiceRequestMapper {
    @Mapping(target = "item.idItem", source = "invoice.idItem")
    @Mapping(target = "item.quantityItem", source = "invoice.quantityItem")
    @Mapping(target = "item.priceItem", source = "invoice.priceItem")
    @Mapping(target = "item.productId", source = "invoice.productId")
    static InvoiceModel toInvoiceRequest(InvoiceRequestDto invoice){
        InvoiceModel invoiceRequest = new InvoiceModel();
        invoiceRequest.setNumber(invoice.getNumber());
        invoiceRequest.setCreateAt(invoice.getCreateAt());
        invoiceRequest.setItem(createItemList(invoice.getIdItem(), invoice.getQuantityItem(), invoice.getPriceItem(), invoice.getProductId()));
        return invoiceRequest;
    }

    static List<ItemModel> createItemList(Long idItem, Double quantityItem, Double priceItem, Long productId) {
        List<ItemModel> invoiceItems = new ArrayList<>();
        // Crear los elementos de factura concretos y agregarlos a la lista
        ItemModel invoiceItem1 = new ItemModel();
        invoiceItem1.setIdItem(idItem);
        invoiceItem1.setQuantityItem(quantityItem);
        invoiceItem1.setPriceItem(priceItem);
        invoiceItem1.setProductId(productId);
        invoiceItems.add(invoiceItem1);
        // Puedes agregar más elementos a la lista si es necesario
        return invoiceItems;
    }


}
