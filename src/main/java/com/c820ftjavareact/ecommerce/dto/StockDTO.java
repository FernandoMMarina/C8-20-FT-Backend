package com.c820ftjavareact.ecommerce.dto;

import com.c820ftjavareact.ecommerce.entity.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class StockDTO {

    private Set<Product> product = new HashSet();
    private Integer quantity;

}