package com.playko.store.domain.usecase;

import com.playko.store.domain.api.IProductServicePort;
import com.playko.store.domain.model.CategoryModel;
import com.playko.store.domain.model.ProductModel;
import com.playko.store.domain.spi.IProductPersistencePort;

import java.util.Date;
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
    public ProductModel createProduct(ProductModel product) {
        return productPersistencePort.createProduct(product);
    }

    @Override
    public ProductModel updateProduct(ProductModel product) {
        return productPersistencePort.updateProduct(product);
    }

    @Override
    public ProductModel deleteProduct(Long id) {
        return productPersistencePort.deleteProduct(id);
    }

    @Override
    public List<ProductModel> findByCategory(CategoryModel category) {
        return productPersistencePort.findByCategory(category);
    }

    @Override
    public ProductModel updateStock(Long id, Double quantity) {
        return productPersistencePort.updateStock(id, quantity);
    }
}
