package com.c820ftjavareact.ecommerce.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.c820ftjavareact.ecommerce.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
