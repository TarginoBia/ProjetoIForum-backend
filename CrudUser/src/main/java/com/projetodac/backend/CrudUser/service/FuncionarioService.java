package com.projeto.IForum.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.IForum.model.Funcionario;
import com.projeto.IForum.repository.FuncionarioRepository;

@Service
public class FuncionarioService{

    private final FuncionarioRepository funcionarioRepository;

    @Autowired 
    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public Funcionario salvarFuncionario(Funcionario funcionario) {
        if (funcionario.getEmail() == null || funcionario.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email é obrigatório.");
        }
        return funcionarioRepository.save(funcionario);
    }

    public Optional<Funcionario> buscarPorId(Long id) {
        return funcionarioRepository.findById(id);
    }

    public List<Funcionario> buscarTodos() {
        return funcionarioRepository.findAll();
    }
    
    public void deletarFuncionario(Long id) {
        funcionarioRepository.deleteById(id);
    }
}
