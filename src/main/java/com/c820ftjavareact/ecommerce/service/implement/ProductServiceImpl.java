package com.c820ftjavareact.ecommerce.service.implement;
import com.c820ftjavareact.ecommerce.dto.ProductBasicDTO;
import com.c820ftjavareact.ecommerce.entity.Product;
import com.c820ftjavareact.ecommerce.dto.ProductDTO;
import com.c820ftjavareact.ecommerce.mapper.ProductMapper;
import com.c820ftjavareact.ecommerce.repository.ProductRepository;
import com.c820ftjavareact.ecommerce.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import javassist.NotFoundException;
import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Autowired
    private  ProductRepository productRepository;


    @Autowired
    private ProductMapper productMapper ;

    @Override
    public ProductDTO createProduct(ProductDTO productDTO)  {
        Product product = productMapper.productDTO2Entity(productDTO);
        Product productSave = productRepository.save(product);
        return productMapper.productEntity2DTO(productSave);
    }



    @Override
    public ProductDTO updateProduct(ProductDTO productDTO,Long id) {
        Product product = productRepository.findById(id).orElse(null);
        assert product != null;
        product.setId(productDTO.getId());
        product.setTitle(productDTO.getTitle());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setImageUrl(productDTO.getImageUrl());
        product.setNote(productDTO.getNote());
        Product productSave = productRepository.save(product);
        return productMapper.productEntity2DTO(productSave);
    }


    public void deleteProduct(Long id) throws NotFoundException {
        Product productEntity = productRepository.findById(id).orElse(null);
       if(productEntity == null) {
            throw new NotFoundException("Product not found");
        }
        productRepository.deleteById(id);

    }

    @Override
    public List<ProductBasicDTO> getProduct() {
        List<Product> products = productRepository.findAll();
        List<ProductBasicDTO> productBasicDTOS = productMapper.productEntityList2DTO(products);
        return productBasicDTOS;
    }

    // Start GetByDi por detalle de product
    @Override
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        assert product != null;
        return productMapper.productEntity2DTO(product);
    }

    

}
