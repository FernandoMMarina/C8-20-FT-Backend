package com.c820ftjavareact.ecommerce.service.implement;

import com.c820ftjavareact.ecommerce.dto.ClientDTORegister;
import com.c820ftjavareact.ecommerce.entity.Client;
import com.c820ftjavareact.ecommerce.mapper.ClientMapper;
import com.c820ftjavareact.ecommerce.repository.ClientRepository;
import com.c820ftjavareact.ecommerce.service.ClientService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ClientServiceImp implements ClientService {

    @Autowired
    private ClientMapper clientMapper;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<ClientDTORegister> getClientListRegisters(){
        List<Client> clients = clientRepository.findAll();
       List<ClientDTORegister> clientDTORegisters = clientMapper.clientDTORegisterList(clients);
       return  clientDTORegisters;
    }

    @Override
    public ClientDTORegister getClientById(Long id) {
        Client client = clientRepository.findById(id).orElse(null);
        assert client != null;
        return clientMapper.clientEntityDTOBasic(client);
    }

    @Override
    public List<ClientDTORegister> getClient() {
        List<Client> clients = clientRepository.findAll();
        List<ClientDTORegister> clientDTORegisters = clientMapper.clientDTORegisterList(clients);
        return  clientDTORegisters;
    }

    @Override
    public ClientDTORegister updateClient(ClientDTORegister clientDto, Long id) throws NotFoundException {
           Client client = clientRepository.findById(id).orElse(null);
           assert client != null;
            client.setName(clientDto.getName());
            client.setSurname(clientDto.getSurname());
            client.setEmail(clientDto.getEmail());
            client.setPassword(clientDto.getPassword());
            client.setAddress(clientDto.getAddress());
            client.setTelephone(clientDto.getTelephone());
            Client response = clientRepository.save(client);
            return clientMapper.clientEntityDTOBasic(response) ;
    }

    @Override
    public void deleteClient(Long id) throws NotFoundException {
        Optional<Client> client = clientRepository.findById(id);
        if(!client.isEmpty()){
            clientRepository.deleteById(id);
        }
        else{
            throw new NotFoundException("Client not found");
        }
    }

    @Override
    public ClientDTORegister createClient(ClientDTORegister ClientDTO) {
        Client client = clientMapper.clientDTOEntity(ClientDTO);
        Client clientSave = clientRepository.save(client);
        return clientMapper.clientEntityDTOBasic(clientSave);
    }



}
