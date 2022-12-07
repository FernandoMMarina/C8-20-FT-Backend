package com.c820ftjavareact.ecommerce.controller;


import com.c820ftjavareact.ecommerce.dto.ClientDTORegister;
import com.c820ftjavareact.ecommerce.repository.ClientRepository;
import com.c820ftjavareact.ecommerce.service.ClientService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/client")
@CrossOrigin(origins = "https://c8-20-ft-javareact-5a91pzs32-villanos.vercel.app/")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/clients")
    public ResponseEntity<List<ClientDTORegister>> getClient(){
        List<ClientDTORegister> clientDTORegisters = clientService.getClientListRegisters();
        return status(HttpStatus.ACCEPTED).body(clientDTORegisters);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDTORegister> getClientById(@PathVariable Long id){
        try {
            ClientDTORegister clientDTORegister = clientService.getClientById(id);
            return ResponseEntity.status(HttpStatus.OK).body(clientDTORegister);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ClientDTORegister> create(@RequestBody ClientDTORegister clientDTORegister){
        clientService.createClient(clientDTORegister);
        return status(HttpStatus.CREATED).body(clientDTORegister);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDTORegister> update(@PathVariable Long id , @RequestBody ClientDTORegister clientDTORegister){
        try{
            ClientDTORegister clientDTORegister1 = clientService.updateClient(clientDTORegister,id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(clientDTORegister1);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteClient(@Parameter(description = "id") @PathVariable Long id){
        try {
            clientService.deleteClient(id);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}