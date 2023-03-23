package com.playko.store.application.mapper;

import com.playko.store.application.dto.request.CustomerRequestDto;
import com.playko.store.domain.model.CustomerModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ICustomerRequestMapper {
    @Mapping(target = "region.idRegion", source = "customer.idRegion")
    @Mapping(target = "region.nameRegion", source = "customer.nameRegion")
    CustomerModel toCustomerRequest(CustomerRequestDto customer);
}
