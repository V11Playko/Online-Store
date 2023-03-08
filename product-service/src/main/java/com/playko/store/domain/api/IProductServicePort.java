package com.playko.store.domain.api;

import com.playko.store.domain.model.CategoryModel;
import com.playko.store.domain.model.ProductModel;

import java.util.List;

public interface IProductServicePort {
     List<ProductModel> listAllProduct();
     ProductModel getProduct(Long id);

     void createProduct(ProductModel product);
     void updateProduct(ProductModel product);
     ProductModel deleteProduct(Long id);
     List<ProductModel> findByCategory(CategoryModel category);
     void updateStock(Long id, Double quantity);
}
