package com.playko.store.application.mapper;

import com.playko.store.application.dto.response.CustomerResponseDto;
import com.playko.store.domain.model.CustomerModel;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ICustomerResponseMapper {
    @Named("customerList")
    List<CustomerResponseDto> toResponseCustomerList(List<CustomerModel> customerModelList);

    @Named("getCustomer")
    CustomerResponseDto toResponseGetCustomer(CustomerModel customer);

    @Named("createCustomer")
    CustomerResponseDto toResponseCreateCustomer(CustomerModel customer);

    @Named("updateCustomer")
    CustomerResponseDto toResponseUpdateCustomer(CustomerModel customer);

    CustomerResponseDto toResponseDeleteCustomer(Long id);

    @Named("findRegion")
    List<CustomerResponseDto> findByRegion(List<CustomerModel> region);
}
