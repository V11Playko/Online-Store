package com.playko.store.infrastructure.out.jpa.mapper;


import com.playko.store.domain.model.InvoiceModel;
import com.playko.store.infrastructure.out.jpa.entity.InvoiceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IInvoiceEntityMapper {
    InvoiceModel toInvoiceModel(InvoiceEntity invoiceEntity);

    List<InvoiceModel> toInvoiceModelList(List<InvoiceEntity> invoiceEntityList);

}
