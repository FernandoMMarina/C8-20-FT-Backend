package com.c820ftjavareact.ecommerce.security;

import com.c820ftjavareact.ecommerce.entity.Client;
import com.c820ftjavareact.ecommerce.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private ClientRepository clientRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
            Client cliente = clientRepository
                    .findOneByEmail(email)
                    .orElseThrow(()-> new UsernameNotFoundException("El usuario con Email" + email + "No existe."));
            return new UserDetailsImpl(cliente);
    }
}
