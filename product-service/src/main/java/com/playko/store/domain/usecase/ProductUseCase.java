package com.playko.store.domain.usecase;

import com.playko.store.domain.api.IProductServicePort;
import com.playko.store.domain.model.CategoryModel;
import com.playko.store.domain.model.ProductModel;
import com.playko.store.domain.spi.IProductPersistencePort;

import java.util.List;

public class ProductUseCase implements IProductServicePort {
    private final IProductPersistencePort productPersistencePort;
    public ProductUseCase(IProductPersistencePort productPersistencePort) {
        this.productPersistencePort = productPersistencePort;
    }
    @Override
    public List<ProductModel> listAllProduct() {
        return productPersistencePort.listAllProduct();
    }

    @Override
    public ProductModel getProduct(Long id) {
        return productPersistencePort.getProduct(id);
    }

    @Override
    public void createProduct(ProductModel product) {
        productPersistencePort.createProduct(product);
    }

    @Override
    public void updateProduct(ProductModel product) {
        productPersistencePort.updateProduct(product);
    }

    @Override
    public ProductModel deleteProduct(Long id) {
        productPersistencePort.deleteProduct(id);
        return null;
    }

    @Override
    public List<ProductModel> findByCategory(CategoryModel category) {
        return productPersistencePort.findByCategory(category);
    }




}
