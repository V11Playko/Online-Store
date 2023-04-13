package com.playko.store.infrastructure.out.jpa.adapter;

import com.playko.store.domain.model.CategoryModel;
import com.playko.store.domain.model.ProductModel;
import com.playko.store.domain.spi.IProductPersistencePort;
import com.playko.store.infrastructure.exception.NoDataFoundException;
import com.playko.store.infrastructure.out.jpa.entity.ProductEntity;
import com.playko.store.infrastructure.out.jpa.mapper.IProductEntityMapper;
import com.playko.store.infrastructure.out.jpa.repository.IProductRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ProductJpaAdapter implements IProductPersistencePort {
    private final IProductRepository productRepository;
    private final IProductEntityMapper productEntityMapper;
    @Override
    public List<ProductModel> listAllProduct() {
        List<ProductEntity> productEntityList = productRepository.findAll();
        if (productEntityList.isEmpty()){
            throw new NoDataFoundException();
        }
        return productEntityMapper.toProductModelList(productEntityList);
    }

    @Override
    public ProductModel getProduct(Long id) {
        return productEntityMapper.toProductModel(productRepository.findById(id).get());
    }

    @Override
    public void createProduct(ProductModel product) {
        ProductEntity productEntity = productEntityMapper.toEntity(product);
        productRepository.save(productEntity);
    }

    @Override
    public void updateProduct(ProductModel product) {
        productRepository.save(productEntityMapper.toEntity(product));
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductModel> findByCategory(CategoryModel category) {
        List<ProductEntity> categoryList = productRepository.findAll();
        return productEntityMapper.toProductModelList(categoryList);
    }

    @Override
    public void updateStock(ProductModel product) {
        productRepository.save(productEntityMapper.toEntity(product));
    }
}
