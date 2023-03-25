package com.playko.store.domain.usecase;

import com.playko.store.application.handler.CustomerHandlerDataTest;
import com.playko.store.domain.model.CustomerModel;
import com.playko.store.domain.spi.ICustomerPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;

class CustumerUseCaseTest {

    @Mock
    private ICustomerPersistencePort customerPersistencePort;
    @InjectMocks
    private CustumerUseCase custumerUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getCustomer() {
        // When
        custumerUseCase.getCustomer(anyLong());

        // Then
        verify(customerPersistencePort).getCustomer(anyLong());
    }

    @Test
    void createCustomer() {
        CustomerModel customer = CustomerUseCaseDataTest.obtainCustomer();

        assertDoesNotThrow(() -> custumerUseCase.createCustomer(customer));
    }

    @Test
    void updateCustomer() {
        CustomerModel customer = CustomerUseCaseDataTest.obtainCustomer();
        custumerUseCase.updateCustomer(customer);

        verify(customerPersistencePort).updateCustomer(customer);
    }

    @Test
    void deleteCustomer() {
        custumerUseCase.deleteCustomer(anyLong());

        verify(customerPersistencePort).deleteCustomer(anyLong());
    }

    @Test
    void findCustomersByRegion() {
        custumerUseCase.findCustomersByRegion(any());

        verify(customerPersistencePort).findCustomersByRegion(any());
    }
}