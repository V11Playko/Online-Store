package com.playko.store.application.handler;

import com.playko.store.application.dto.request.ProductRequestDto;
import com.playko.store.domain.model.CategoryModel;
import com.playko.store.domain.model.ProductModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductHandlerDataTest {
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
    public static ProductRequestDto obtainProductRequest() {
        ProductRequestDto product = new ProductRequestDto();

        product.setName("Prada");
        product.setDescription("Valioso");
        product.setPrice(15.0);
        product.setStock(50.0);
        product.setStatus("Almacenado");
        product.setCreateAt(new Date());
        CategoryModel category = new CategoryModel(10L, "zapatos");

        return product;
    }

    public static List<ProductModel> obtainProducts() {
        List<ProductModel> productList = new ArrayList<>();
        return  productList;
    }
}
