package com.playko.store.domain.api;

import com.playko.store.domain.model.CustomerModel;
import com.playko.store.domain.model.RegionModel;

import java.util.List;

public interface ICustumerServicePort {
    List<CustomerModel> listAllCustomer();
    CustomerModel getCustomer(Long id);
    void createCustomer(CustomerModel customerModel);
    void updateCustomer(CustomerModel customerModel);
    CustomerModel deleteCustomer(Long id);

    List<CustomerModel> findCustomersByRegion(RegionModel regionModel);
}
