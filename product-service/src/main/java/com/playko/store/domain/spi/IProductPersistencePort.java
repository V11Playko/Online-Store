package com.playko.store.domain.spi;

import com.playko.store.domain.model.CategoryModel;
import com.playko.store.domain.model.ProductModel;

import java.util.List;

public interface IProductPersistencePort {
    // Cambiar el model luego por el entity
    List<ProductModel> listAllProduct();
    ProductModel getProduct(Long id);

    void createProduct(ProductModel product);
    void updateProduct(ProductModel product);
    void deleteProduct(Long id);
    List<ProductModel> findByCategory(CategoryModel category);
}
