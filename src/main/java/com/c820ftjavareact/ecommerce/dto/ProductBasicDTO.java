package com.c820ftjavareact.ecommerce.dto;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ProductBasicDTO {

    @NotNull
    private long id;
    @NotNull
    private String imageUrl;
    @NotNull
    private String title;
    @NotNull
    private String description;
    @NotNull
    private double price;

    @NotNull
    private long stock;

    @NotNull
    private String category;

}
