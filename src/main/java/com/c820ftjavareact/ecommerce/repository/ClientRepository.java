package com.c820ftjavareact.ecommerce.repository;

import com.c820ftjavareact.ecommerce.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ClientRepository  extends JpaRepository<Client, Long> {

}
