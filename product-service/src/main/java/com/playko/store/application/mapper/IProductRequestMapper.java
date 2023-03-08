package com.playko.store.application.mapper;

import com.playko.store.application.dto.request.ProductRequestDto;
import com.playko.store.domain.model.ProductModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IProductRequestMapper {
    @Mapping(target = "category.idCategory", source = "product.idCategory")
    @Mapping(target = "category.nameCategory", source = "product.nameCategory")
    ProductModel toProductRequest(ProductRequestDto product);
}
