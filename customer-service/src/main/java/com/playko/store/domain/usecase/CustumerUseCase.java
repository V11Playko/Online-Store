package com.playko.store.domain.usecase;

import com.playko.store.domain.api.ICustumerServicePort;
import com.playko.store.domain.model.CustomerModel;
import com.playko.store.domain.model.RegionModel;
import com.playko.store.domain.spi.ICustomerPersistencePort;

import java.util.List;

public class CustumerUseCase implements ICustumerServicePort {
    private final ICustomerPersistencePort customerPersistencePort;
    public CustumerUseCase(ICustomerPersistencePort customerPersistencePort) {
        this.customerPersistencePort = customerPersistencePort;
    }

    @Override
    public List<CustomerModel> listAllCustomer() {
        return customerPersistencePort.listAllCustomer();
    }

    @Override
    public CustomerModel getCustomer(Long id) {
        return customerPersistencePort.getCustomer(id);
    }

    @Override
    public void createCustomer(CustomerModel customer) {
        customerPersistencePort.createCustomer(customer);
    }

    @Override
    public void updateCustomer(CustomerModel customer) {
        customerPersistencePort.updateCustomer(customer);
    }

    @Override
    public CustomerModel deleteCustomer(Long id) {
        customerPersistencePort.deleteCustomer(id);
        return null;
    }

    @Override
    public List<CustomerModel> findCustomersByRegion(RegionModel region) {
        return customerPersistencePort.findCustomersByRegion(region);
    }
}
