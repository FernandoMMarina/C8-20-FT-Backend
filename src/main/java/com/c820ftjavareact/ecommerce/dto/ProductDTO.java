package com.c820ftjavareact.ecommerce.dto;

import com.c820ftjavareact.ecommerce.entity.Stock;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

    @NotNull
    private long id;

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private double price;

    @NotNull
    private String imageUrl;
    private String note;
    private Long stock;

    private String category;

}