package com.playko.store.application.handler;

import com.playko.store.application.dto.request.ProductRequestDto;
import com.playko.store.application.handler.impl.ProductHandler;
import com.playko.store.application.mapper.IProductRequestMapper;
import com.playko.store.application.mapper.IProductResponseMapper;
import com.playko.store.domain.api.IProductServicePort;
import com.playko.store.domain.model.ProductModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
class ProductHandlerTest {

    @InjectMocks
    ProductHandler productHandler;
    @Mock
    IProductServicePort productServicePort;
    @Mock
    IProductRequestMapper productRequestMapper;
    @Mock
    IProductResponseMapper productResponseMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listAllProduct() {
        List<ProductModel> productList = ProductHandlerDataTest.obtainProducts();

        when(productServicePort.listAllProduct()).thenReturn(productList);
        assertEquals(productHandler.listAllProduct(), productList);
    }

    @Test
    void getProduct() {
        ProductModel product = ProductHandlerDataTest.obtainProduct();

        when(productServicePort.getProduct(anyLong())).thenReturn(product);
        productHandler.getProduct(anyLong());

        verify(productResponseMapper).toResponseGetProduct(product);
    }

    @Test
    void createProduct() {
        ProductModel product = ProductHandlerDataTest.obtainProduct();
        ProductRequestDto productRequest = ProductHandlerDataTest.obtainProductRequest();

        when(productRequestMapper.toProductRequest(productRequest)).thenReturn(product);
        productHandler.createProduct(productRequest);

        verify(productServicePort).createProduct(product);
    }

}