package com.playko.store.application.handler;

import com.playko.store.application.dto.request.CustomerRequestDto;
import com.playko.store.application.handler.impl.CustomerHandler;
import com.playko.store.application.mapper.ICustomerRequestMapper;
import com.playko.store.application.mapper.ICustomerResponseMapper;
import com.playko.store.domain.api.ICustumerServicePort;
import com.playko.store.domain.model.CustomerModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CustumerHandlerTest {
    @InjectMocks
    CustomerHandler customerHandler;
    @Mock
    ICustumerServicePort custumerServicePort;
    @Mock
    ICustomerRequestMapper customerRequestMapper;
    @Mock
    ICustomerResponseMapper customerResponseMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listAllCustomer() {
        List<CustomerModel> customerList = CustomerHandlerDataTest.obtainCustomers();

        when(custumerServicePort.listAllCustomer()).thenReturn(customerList);
        assertEquals(customerHandler.listAllCustomer(), customerList);
    }

    @Test
    void getCustomer() {
        CustomerModel customer = CustomerHandlerDataTest.obtainCustomer();

        when(custumerServicePort.getCustomer(anyLong())).thenReturn(customer);
        customerHandler.getCustomer(anyLong());

        verify(customerResponseMapper).toResponseGetCustomer(customer);
    }

    @Test
    void createCustomer() {
        CustomerModel customer = CustomerHandlerDataTest.obtainCustomer();
        CustomerRequestDto customerRequest = CustomerHandlerDataTest.obtainCustomerRequest();

        when(customerRequestMapper.toCustomerRequest(customerRequest)).thenReturn(customer);
        customerHandler.createCustomer(customerRequest);

        verify(custumerServicePort).createCustomer(customer);
    }

}