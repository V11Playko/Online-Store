package com.playko.store.infrastructure.out.jpa.mapper;

import com.playko.store.domain.model.ProductModel;
import com.playko.store.infrastructure.out.jpa.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IProductEntityMapper {
    ProductEntity toEntity(ProductModel productModel);
    ProductModel toProductModel(ProductEntity productEntity);
    List<ProductModel> toProductModelList(List<ProductEntity> productEntityList);
}
