package com.playko.store.application.dto.request;

import com.playko.store.domain.model.CategoryModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ProductRequestDto {
    private Long id;
    private String name;
    private String description;
    private Double stock;
    private Double price;
    private String status;
    private Date createAt;

    // Category
    private Long idCategory;
    private String nameCategory;
}
