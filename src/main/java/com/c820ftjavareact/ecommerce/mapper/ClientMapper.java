package com.c820ftjavareact.ecommerce.mapper;


import com.c820ftjavareact.ecommerce.dto.ClientDTORegister;
import com.c820ftjavareact.ecommerce.entity.Client;
import jdk.jfr.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientMapper {

    public ClientDTORegister clientEntityDTOBasic(Client client){
        ClientDTORegister clientDTORegister = new ClientDTORegister();
        clientDTORegister.setId(client.getId());
        clientDTORegister.setName(client.getName());
        clientDTORegister.setSurname(client.getSurname());
        clientDTORegister.setEmail(client.getEmail());
        clientDTORegister.setAddress(client.getAddress());
        clientDTORegister.setTelephone(client.getTelephone());
        clientDTORegister.setPassword(client.getPassword());

        return  clientDTORegister;
    }

    public List<ClientDTORegister>clientDTORegisterList(List<Client>clients){
        List<ClientDTORegister>clientDTORegisters = new ArrayList<>();
        for (Client client : clients){
            clientDTORegisters.add(this.clientEntityDTOBasic(client));
        }
        return clientDTORegisters;
    }

    public Client clientDTOEntity ( ClientDTORegister clientDTORegister){
        Client client = new Client();
        client.setName(clientDTORegister.getName());
        client.setSurname(clientDTORegister.getSurname());
        client.setEmail(clientDTORegister.getEmail());
        client.setPassword(clientDTORegister.getPassword());
        client.setAddress(clientDTORegister.getAddress());
        client.setTelephone(clientDTORegister.getTelephone());
        return client;
    }

}
