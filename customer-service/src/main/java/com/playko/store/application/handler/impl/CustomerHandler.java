package com.playko.store.application.handler.impl;

import com.playko.store.application.dto.request.CustomerRequestDto;
import com.playko.store.application.dto.response.CustomerResponseDto;
import com.playko.store.application.handler.ICustumerHandler;
import com.playko.store.application.mapper.ICustomerRequestMapper;
import com.playko.store.application.mapper.ICustomerResponseMapper;
import com.playko.store.domain.api.ICustumerServicePort;
import com.playko.store.domain.model.CustomerModel;
import com.playko.store.domain.model.RegionModel;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerHandler implements ICustumerHandler {
    private final ICustumerServicePort custumerServicePort;
    private final ICustomerRequestMapper customerRequestMapper;
    private final ICustomerResponseMapper customerResponseMapper;

    @Override
    public List<CustomerResponseDto> listAllCustomer() {
        return customerResponseMapper.toResponseCustomerList(custumerServicePort.listAllCustomer());
    }

    @Override
    public CustomerResponseDto getCustomer(Long id) {
        CustomerModel customerModel = custumerServicePort.getCustomer(id);
        return customerResponseMapper.toResponseGetCustomer(customerModel);
    }

    @Override
    public void createCustomer(CustomerRequestDto customer) {
        customer.setState("CREATED");

        CustomerModel customerModel = customerRequestMapper.toCustomerRequest(customer);
        custumerServicePort.createCustomer(customerModel);
    }

    @Override
    public void updateCustomer(CustomerRequestDto customer) {
        CustomerModel customerModel = custumerServicePort.getCustomer(customer.getId());
        if (Strings.isNotBlank(customer.getDni()) || Strings.isNotEmpty(customer.getDni())) customerModel.setDni(customer.getDni());

        customerModel.setFirstName(customer.getFirstName());
        customerModel.setLastName(customer.getLastName());
        customerModel.setEmail(customer.getEmail());
        customerModel.setPhotoUrl(customer.getPhotoUrl());
        customerModel.setRegion(customerModel.getRegion());

        custumerServicePort.updateCustomer(customerModel);
    }

    @Override
    public void deleteCustomer(Long id) {
        CustomerModel customerModel = custumerServicePort.deleteCustomer(id);
    }

    @Override
    public List<CustomerResponseDto> findByRegion(RegionModel region) {
        return customerResponseMapper.findByRegion(custumerServicePort.findCustomersByRegion(region));
    }
}
