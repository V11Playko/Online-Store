package com.playko.store.application.handler;

import com.playko.store.application.dto.request.ProductRequestDto;
import com.playko.store.application.dto.response.ProductResponseDto;
import com.playko.store.domain.model.CategoryModel;

import java.util.List;

public interface IProductHandler {
    List<ProductResponseDto> listAllProduct();
    ProductResponseDto getProduct(Long id);
    void  createProduct(ProductRequestDto product);
    void  updateProduct(ProductRequestDto product);
    void  deleteProduct(Long id);
    List<ProductResponseDto> findByCategory(CategoryModel category);

    void updateStock(Long id, Double quantity);
}
