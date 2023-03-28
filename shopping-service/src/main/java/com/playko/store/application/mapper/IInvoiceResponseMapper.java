package com.playko.store.application.mapper;

import com.playko.store.application.dto.response.InvoiceResponseDto;
import com.playko.store.domain.model.InvoiceModel;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IInvoiceResponseMapper {
    @Named("invoiceList")
    List<InvoiceResponseDto> toResponseInvoiceList(List<InvoiceModel> invoiceModelList);
    @Named("getInvoice")
    InvoiceResponseDto toResponseGetInvoice(InvoiceModel invoice);
    @Named("createInvoice")
    InvoiceResponseDto toResponseCreateInvoice(InvoiceModel invoice);
    @Named("updateInvoice")
    InvoiceResponseDto toResponseUpdateInvoice(InvoiceModel invoice);

    InvoiceResponseDto toResponseDeleteInvoice(Long id);
}
