package com.c820ftjavareact.ecommerce.mapper;

import com.c820ftjavareact.ecommerce.dto.ProductBasicDTO;
import com.c820ftjavareact.ecommerce.dto.ProductDTO;
import com.c820ftjavareact.ecommerce.entity.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapper {
    public Product productDTO2Entity (ProductDTO productDTO){

        Product product = new Product();
        product.setId(product.getId());
        product.setTitle(productDTO.getTitle());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setImageUrl(productDTO.getImageUrl());
        product.setNote(productDTO.getNote());
      //product.setStock(productDTO.getStock());
        return product;
    }

    public ProductDTO productEntity2DTO (Product  product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(productDTO.getId());
        productDTO.setTitle(product.getTitle());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setImageUrl(product.getImageUrl());
        productDTO.setNote(product.getNote());
      //productDTO.setStock(product.getStock()); //<-----------------Falta esto

        return  productDTO;
    }

    //listar product
    public List<ProductBasicDTO> productEntityList2DTO(List<Product> products){
        List<ProductBasicDTO>productBasicDTOS = new ArrayList<>();
        for (Product product : products){
            productBasicDTOS.add(this.productEntity2DTOBasic(product));
        }
        return productBasicDTOS;

    }

    public ProductBasicDTO productEntity2DTOBasic(Product product) {
        ProductBasicDTO productBasicDTO = new ProductBasicDTO();
        productBasicDTO.setId(product.getId());
        productBasicDTO.setImageUrl(product.getImageUrl());
        productBasicDTO.setTitle(product.getTitle());
        productBasicDTO.setPrice(product.getPrice());
        productBasicDTO.setDescription(product.getDescription());//<---- Falto esto
        return productBasicDTO;
    }


}
