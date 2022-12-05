package com.c820ftjavareact.ecommerce.repository;

import com.c820ftjavareact.ecommerce.entity.Role;

import java.util.Optional;

public interface RoleRepository {
    Optional<Role> findByName(String role_user);
}
