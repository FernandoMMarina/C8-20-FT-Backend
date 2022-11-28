package com.c820ftjavareact.ecommerce.service;
import com.c820ftjavareact.ecommerce.dto.ProductBasicDTO;
import javassist.NotFoundException;
import com.c820ftjavareact.ecommerce.dto.ProductDTO;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface ProductService {
    ProductDTO createProduct (ProductDTO dto);
    ProductDTO updateProduct(ProductDTO productDTO, Long id);
    void deleteProduct(Long id) throws NotFoundException;

    List<ProductBasicDTO> getProduct();
    ProductDTO getProductById(Long id);

    //CategoryDTO getCategoryById(String id);
    // List<CategoryBasicDTO> getCategory();



}
