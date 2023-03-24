package com.playko.store.infrastructure.out.jpa.adapter;

import com.playko.store.domain.model.CustomerModel;
import com.playko.store.domain.model.RegionModel;
import com.playko.store.domain.spi.ICustomerPersistencePort;
import com.playko.store.infrastructure.exception.NoDataFoundException;
import com.playko.store.infrastructure.out.jpa.entity.CustomerEntity;
import com.playko.store.infrastructure.out.jpa.mapper.ICustomerEntityMapper;
import com.playko.store.infrastructure.out.jpa.repository.ICustomerRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CustomerJpaAdapter implements ICustomerPersistencePort {
    private final ICustomerRepository customerRepository;
    private final ICustomerEntityMapper customerEntityMapper;

    @Override
    public List<CustomerModel> listAllCustomer() {
        List<CustomerEntity> customerEntityList = customerRepository.findAll();
        if (customerEntityList.isEmpty()){
            throw new NoDataFoundException();
        }
        return customerEntityMapper.toCustomerModelList(customerEntityList);
    }

    @Override
    public CustomerModel getCustomer(Long id) {
        return customerEntityMapper.toCustomerModel(customerRepository.findById(id).get());
    }

    @Override
    public void createCustomer(CustomerModel customerModel) {
        CustomerEntity customerEntity = customerEntityMapper.toEntity(customerModel);
        customerRepository.save(customerEntity);
    }

    @Override
    public void updateCustomer(CustomerModel customerModel) {
        customerRepository.save(customerEntityMapper.toEntity(customerModel));
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<CustomerModel> findCustomersByRegion(RegionModel regionModel) {
        List<CustomerEntity> regionList = customerRepository.findAll();
        return customerEntityMapper.toCustomerModelList(regionList);
    }
}
