package com.playko.store.infrastructure.out.jpa.adapter;

import com.playko.store.domain.model.CustomerModel;
import com.playko.store.infrastructure.out.jpa.entity.CustomerEntity;
import com.playko.store.infrastructure.out.jpa.mapper.ICustomerEntityMapper;
import com.playko.store.infrastructure.out.jpa.repository.ICustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@ExtendWith(SpringExtension.class)
class CustomerJpaAdapterTest {

    @InjectMocks
    CustomerJpaAdapter customerJpaAdapter;
    @Mock
    ICustomerRepository customerRepository;
    @Mock
    ICustomerEntityMapper customerMapper;

    @Test
    void createCustomer() {
        CustomerModel customerModel = CustomerJpaAdapterDataTest.obtainCustomer();
        CustomerEntity customerEntity = CustomerJpaAdapterDataTest.obtainCustomerEnity();

        when(customerMapper.toEntity(customerModel)).thenReturn(customerEntity);
        customerJpaAdapter.createCustomer(customerModel);

        verify(customerRepository).save(customerEntity);
    }

    @Test
    void updateCustomer() {
        CustomerModel customer = CustomerJpaAdapterDataTest.obtainCustomer();
        customerJpaAdapter.updateCustomer(customer);

        verify(customerRepository).save(customerMapper.toEntity(customer));
    }

    @Test
    void deleteCustomer() {
        customerJpaAdapter.deleteCustomer(anyLong());

        verify(customerRepository).deleteById(anyLong());
    }
}