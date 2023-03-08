package com.playko.store.application.mapper;

import com.playko.store.application.dto.response.ProductResponseDto;
import com.playko.store.domain.model.CategoryModel;
import com.playko.store.domain.model.ProductModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IProductResponseMapper {
    List<ProductResponseDto> toResponseProductList(List<ProductModel> productModelList);
    ProductResponseDto toResponseGetProduct(ProductModel product);

    ProductResponseDto toResponseCreateProduct(ProductModel product);
    ProductResponseDto toResponseUpdateProduct(ProductModel product);
    ProductResponseDto toResponseDeleteProduct(Long id);
    List<ProductResponseDto> findByCategory(List<ProductModel> category);
    ProductResponseDto toResponseUpdateStock(Long id, Double quantity);
}
