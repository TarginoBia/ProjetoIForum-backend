package com.projetodac.backend.CrudUser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.projetodac.backend.CrudUser.model.User;
import com.projetodac.backend.CrudUser.repository.UserRepository;

@Service
public class UserDetailsServiceImplem implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;
    
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com o e-mail: " + email));
        
        return user;
    }
}
