package com.c820ftjavareact.ecommerce.dto;

import com.c820ftjavareact.ecommerce.entity.Role;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientDTORegister {

    @NotNull
    private long id;

    @NotNull
    private String password;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    private String email;

    @NotNull
    private String telephone;

    @NotNull
    private String address;

    private Role role;

}