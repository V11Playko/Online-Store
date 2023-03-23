package com.playko.store.domain.spi;

import com.playko.store.domain.model.CustomerModel;
import com.playko.store.domain.model.RegionModel;

import java.util.List;

public interface ICustomerPersistencePort {
    // Cambiar el model luego por el entity
    List<CustomerModel> listAllCustomer();
    CustomerModel getCustomer(Long id);
    void createCustomer(CustomerModel customerModel);
    void updateCustomer(CustomerModel customerModel);
    void deleteCustomer(Long id);

    List<CustomerModel> findCustomersByRegion(RegionModel regionModel);

}
