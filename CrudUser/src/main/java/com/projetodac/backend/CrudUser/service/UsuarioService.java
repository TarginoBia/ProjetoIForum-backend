package com.projeto.IForum.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.IForum.model.Usuario;
import com.projeto.IForum.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Optional<Usuario> findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
    
    public void checkEmailUniqueness(String email) {
        if (usuarioRepository.existsByEmail(email)) {
            throw new RuntimeException("O email já está em uso."); 
        }
    }
    
}