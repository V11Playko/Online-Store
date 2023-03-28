package com.playko.store.application.mapper;

import com.playko.store.application.dto.request.InvoiceRequestDto;
import com.playko.store.domain.model.InvoiceModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IInvoiceRequestMapper {

    @Mapping(target = "items.idItem", source = "invoice.idItem")
    @Mapping(target = "items.quantityItem", source = "invoice.quantityItem")
    @Mapping(target = "items.price", source = "invoice.price")
    @Mapping(target = "items.productId", source = "invoice.productId")
    InvoiceModel toInvoiceRequest(InvoiceRequestDto invoice);

}
