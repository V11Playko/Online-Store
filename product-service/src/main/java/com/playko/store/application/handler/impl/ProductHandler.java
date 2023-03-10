package com.playko.store.application.handler.impl;

import com.playko.store.application.dto.request.ProductRequestDto;
import com.playko.store.application.dto.response.ProductResponseDto;
import com.playko.store.application.handler.IProductHandler;
import com.playko.store.application.mapper.IProductRequestMapper;
import com.playko.store.application.mapper.IProductResponseMapper;
import com.playko.store.domain.api.IProductServicePort;
import com.playko.store.domain.model.CategoryModel;
import com.playko.store.domain.model.ProductModel;
import com.playko.store.infrastructure.out.jpa.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductHandler implements IProductHandler {
    private final IProductServicePort productServicePort;
    private final IProductRequestMapper productRequestMapper;
    private final IProductResponseMapper productResponseMapper;

    @Override
    public List<ProductResponseDto> listAllProduct() {
        return productResponseMapper.toResponseProductList(productServicePort.listAllProduct());
    }

    @Override
    public ProductResponseDto getProduct(Long id) {
        ProductModel productModel = productServicePort.getProduct(id);
        return productResponseMapper.toResponseGetProduct(productModel);
    }

    @Override
    public void createProduct(ProductRequestDto product) {
        product.setStatus("CREATED");
        product.setCreateAt(new Date());

        ProductModel productModel = productRequestMapper.toProductRequest(product);
        productServicePort.createProduct(productModel);
    }

    @Override
    public void updateProduct(ProductRequestDto product) {
        ProductModel productModel = productServicePort.getProduct(product.getId());
        if (Strings.isNotBlank(product.getDescription()) || Strings.isNotEmpty(product.getDescription())) productModel.setDescription(product.getDescription());
        if (product.getPrice() > 0) productModel.setPrice(product.getPrice());

        productModel.setName(product.getName());
        productModel.setDescription(product.getDescription());
        productModel.setStock(product.getStock());
        productModel.setPrice(product.getPrice());
        productModel.setCategory(productModel.getCategory());

        productServicePort.updateProduct(productModel);
    }

    @Override
    public void deleteProduct(Long id) {
        ProductModel productModel = productServicePort.deleteProduct(id);
        if (productModel == null){
            System.err.println("El producto no existe.");
        }
        productModel.setStatus("DELETED");
        productServicePort.deleteProduct(id);

    }

    @Override
    public List<ProductResponseDto> findByCategory(CategoryModel category) {
        return productResponseMapper.findByCategory(productServicePort.findByCategory(category));
    }

    @Override
    public void updateStock(Long id, Double quantity) {
        ProductModel productModel = productServicePort.getProduct(id);
        if (productModel == null) {
            System.err.println("El producto no existe.");
        }
        Double stock = productModel.getStock() + quantity;
        productModel.setStock(stock);
        productServicePort.updateStock(id, stock);
    }
}
