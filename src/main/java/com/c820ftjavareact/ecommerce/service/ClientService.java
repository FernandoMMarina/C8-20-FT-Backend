package com.c820ftjavareact.ecommerce.service;

import com.c820ftjavareact.ecommerce.dto.ClientDTORegister;
import com.c820ftjavareact.ecommerce.entity.Client;
import javassist.NotFoundException;
import java.util.List;


public interface ClientService {

    List<ClientDTORegister> getClientListRegisters();

    ClientDTORegister getClientById(Long id);

    List<ClientDTORegister> getClient();

    ClientDTORegister updateClient(ClientDTORegister dto , Long id) throws NotFoundException;
    void deleteClient(Long id) throws NotFoundException;

    ClientDTORegister createClient(ClientDTORegister ClientDTO);




}
