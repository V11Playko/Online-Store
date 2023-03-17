package com.playko.store.infrastructure.out.jpa.adapter;

import com.playko.store.domain.model.ProductModel;
import com.playko.store.infrastructure.out.jpa.entity.ProductEntity;
import com.playko.store.infrastructure.out.jpa.mapper.IProductEntityMapper;
import com.playko.store.infrastructure.out.jpa.repository.IProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@ExtendWith(SpringExtension.class)
class ProductJpaAdapterTest {
    @InjectMocks
    ProductJpaAdapter productJpaAdapter;
    @Mock
    IProductRepository productRepository;
    @Mock
    IProductEntityMapper productMapper;

    @Test
    void createProduct() {
        ProductModel productModel = ProductJpaAdapterDataTest.obtainProduct();
        ProductEntity productEntity = ProductJpaAdapterDataTest.obtainProductEntity();

        when(productMapper.toEntity(productModel)).thenReturn(productEntity);
        productJpaAdapter.createProduct(productModel);

        verify(productRepository).save(productEntity);
    }

    @Test
    void updateProduct() {
        ProductModel productModel = ProductJpaAdapterDataTest.obtainProduct();
        productJpaAdapter.updateProduct(productModel);

        verify(productRepository).save(productMapper.toEntity(productModel));
    }

    @Test
    void deleteProduct() {
        productJpaAdapter.deleteProduct(anyLong());

        verify(productRepository).deleteById(anyLong());
    }

}