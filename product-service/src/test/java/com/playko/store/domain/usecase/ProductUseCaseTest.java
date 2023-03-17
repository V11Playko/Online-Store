package com.playko.store.domain.usecase;

import com.playko.store.domain.model.CategoryModel;
import com.playko.store.domain.model.ProductModel;
import com.playko.store.domain.spi.IProductPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;


import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;

class ProductUseCaseTest {

    @Mock
    private IProductPersistencePort productPersistencePort;
    @InjectMocks
    private ProductUseCase productUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getProduct() {
        // When
        productUseCase.getProduct(anyLong());

        // Then
        verify(productPersistencePort).getProduct(anyLong());
    }

    @Test
    void createProduct() {
        ProductModel product = new ProductModel();

        product.setName("Prada");
        product.setDescription("Valioso");
        product.setPrice(15.0);
        product.setStock(50.0);
        product.setStatus("Almacenado");
        product.setCreateAt(new Date());

        CategoryModel category = new CategoryModel(10L, "zapatos");
        assertDoesNotThrow(() -> productUseCase.createProduct(product));
    }

    @Test
    void updateProduct() {
        ProductModel product = ProductUseCaseDataTest.obtainProduct();
        productUseCase.updateProduct(product);

        verify(productPersistencePort).updateProduct(product);
    }

    @Test
    void deleteProduct() {
        productUseCase.deleteProduct(anyLong());

        verify(productPersistencePort).deleteProduct(anyLong());
    }

    @Test
    void findByCategory() {
        productUseCase.findByCategory(any());

        verify(productPersistencePort).findByCategory(any());
    }
}