package com.c820ftjavareact.ecommerce.controller;
import com.c820ftjavareact.ecommerce.dto.ProductBasicDTO;
import com.c820ftjavareact.ecommerce.dto.ProductDTO;
import com.c820ftjavareact.ecommerce.service.ProductService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
@CrossOrigin(origins = "https://c8-20-ft-javareact-5a91pzs32-villanos.vercel.app/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/")
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO productDTO) {
        productService.createProduct(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(productDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id,@RequestBody ProductDTO productDTO) {
        try{
            ProductDTO productDTO1 = productService.updateProduct(productDTO,id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(productDTO1);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @DeleteMapping(value = "/{id}")

    public ResponseEntity<Object> deleteProduct (@PathVariable Long id){
    try{
            productService.deleteProduct(id);
        }
        catch (NotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    //listar product
    @GetMapping("/products")
    public ResponseEntity<List<ProductBasicDTO>> getProduct() {
        List<ProductBasicDTO> productBasicDTOS = productService.getProduct();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(productBasicDTOS);
    }

    //Detalle of product for ById
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(
                                                       @PathVariable Long id) {
        try {
            ProductDTO productDTO = productService.getProductById(id);
            return ResponseEntity.status(HttpStatus.OK).body(productDTO);
        } catch (Exception e) {
            return new ResponseEntity("Product not found", HttpStatus.NOT_FOUND);
        }
    }


}
