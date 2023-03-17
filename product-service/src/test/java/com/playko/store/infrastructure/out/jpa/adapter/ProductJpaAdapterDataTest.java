package com.playko.store.infrastructure.out.jpa.adapter;

import com.playko.store.domain.model.CategoryModel;
import com.playko.store.domain.model.ProductModel;
import com.playko.store.infrastructure.out.jpa.entity.CategoryEntity;
import com.playko.store.infrastructure.out.jpa.entity.ProductEntity;

import java.util.Date;

public class ProductJpaAdapterDataTest {
    public static ProductModel obtainProduct(){

        return new ProductModel(
                2L,
                "Prada",
                "Caro",
                20.0,
                150.0,
                "Almacenado",
                new Date(),
                new CategoryModel(1L, "zapatos")

        );
    }
    public static ProductEntity obtainProductEntity() {
        ProductEntity product = new ProductEntity();

        product.setId(1L);
        product.setName("Prada");
        product.setDescription("Valioso");
        product.setPrice(15.0);
        product.setStock(50.0);
        product.setStatus("Almacenado");
        product.setCreateAt(new Date());
        product.setCategory(new CategoryEntity(1L, "zapatos"));

        return product;
    }
}
