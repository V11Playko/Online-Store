package com.playko.store.application.dto.response;

import com.playko.store.domain.model.CategoryModel;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProductResponseDto {
    private Long id;
    private String name;
    private String description;
    private Double stock;
    private Double price;
    private String status;
    private Date createAt;
    private CategoryModel category;
}
