package com.playko.store.infrastructure.out.jpa.mapper;

import com.playko.store.domain.model.CustomerModel;
import com.playko.store.infrastructure.out.jpa.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ICustomerEntityMapper {
    CustomerEntity toEntity(CustomerModel customerModel);
    CustomerModel toCustomerModel(CustomerEntity customerEntity);
    List<CustomerModel> toCustomerModelList(List<CustomerEntity> customerEntityList);
}
