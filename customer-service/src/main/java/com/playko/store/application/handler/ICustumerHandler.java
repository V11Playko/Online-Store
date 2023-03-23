package com.playko.store.application.handler;

import com.playko.store.application.dto.request.CustomerRequestDto;
import com.playko.store.application.dto.response.CustomerResponseDto;
import com.playko.store.domain.model.CustomerModel;
import com.playko.store.domain.model.RegionModel;

import java.util.List;

public interface ICustumerHandler {
    List<CustomerResponseDto> listAllCustomer();
    CustomerResponseDto getCustomer(Long id);
    void createCustomer(CustomerRequestDto customer);
    void updateCustomer(CustomerRequestDto customer);
    void deleteCustomer(Long id);
    List<CustomerResponseDto> findByRegion(RegionModel region);
}
