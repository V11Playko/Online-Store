package com.playko.store.application.mapper;

import com.playko.store.application.dto.response.ProductResponseDto;
import com.playko.store.domain.model.ProductModel;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IProductResponseMapper {
    @Named("productList")
    List<ProductResponseDto> toResponseProductList(List<ProductModel> productModelList);
    @Named("getProduct")
    ProductResponseDto toResponseGetProduct(ProductModel product);
    @Named("createProduct")
    ProductResponseDto toResponseCreateProduct(ProductModel product);
    @Named("updateProduct")
    ProductResponseDto toResponseUpdateProduct(ProductModel product);
    ProductResponseDto toResponseDeleteProduct(Long id);
    @Named("findCategory")
    List<ProductResponseDto> findByCategory(List<ProductModel> category);

    @Named("updateStock")
    ProductResponseDto updateStock(Long id, Double quantity);
}
