package com.c820ftjavareact.ecommerce.dto;

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

}