package com.c820ftjavareact.ecommerce.repository;

import com.c820ftjavareact.ecommerce.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ClientRepository  extends JpaRepository<Client, Long> {

    Optional<Client>findOneByEmail(String email);

}
