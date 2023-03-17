package com.playko.store.domain.usecase;

import com.playko.store.domain.model.CategoryModel;
import com.playko.store.domain.model.ProductModel;

import java.util.Date;

public class ProductUseCaseDataTest {
    public static ProductModel obtainProduct(){

        return new ProductModel(
                2L,
                "Prada",
                "Caro",
                20.0,
                150.0,
                "Almacenado",
                new Date(),
                new CategoryModel(
                        2L,
                        "zapatos"
                )
        );
    }
}
