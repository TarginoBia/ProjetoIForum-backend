package com.projeto.IForum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.IForum.dto.FuncionarioDTO;
import com.projeto.IForum.model.Funcionario;
import com.projeto.IForum.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;
    
    @Autowired
    private UsuarioService usuarioService;

    public FuncionarioDTO create(FuncionarioDTO funcionarioDTO) {
        usuarioService.checkEmailUniqueness(funcionarioDTO.getEmail());
        
        Funcionario funcionario = new Funcionario();
        funcionario.setName(funcionarioDTO.getName());
        funcionario.setEmail(funcionarioDTO.getEmail());
        funcionario.setSenha(funcionarioDTO.getSenha()); 
        funcionario.setCargo(funcionarioDTO.getCargo());
        
        funcionario = funcionarioRepository.save(funcionario);
        
        return new FuncionarioDTO(funcionario);
    }
    
}