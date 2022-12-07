package com.c820ftjavareact.ecommerce.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "product")
@Getter
@Setter
@Entity /*
@SQLDelete(sql = "UPDATE product SET deleted = true WHERE id=?")
@Where(clause = "deleted = false") */
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private double price;

    @NotNull
    private String imageUrl;

    private String note;

    @NotNull
    private Long stock;

    @NotNull
    private String categoria;
}