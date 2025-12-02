package com.projeto.IForum.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.IForum.dto.FuncionarioDTO;
import com.projeto.IForum.model.Funcionario;
import com.projeto.IForum.repository.FuncionarioRepository;

@Service
public class FuncionarioService{

    private final FuncionarioRepository funcionarioRepository;
 
    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @Transactional
    public FuncionarioDTO salvar(FuncionarioDTO dto) {
        Funcionario funcionario = FuncionarioDTO.toEntity(dto);
        Funcionario funcionarioSalvo = funcionarioRepository.save(funcionario);
        return FuncionarioDTO.fromEntity(funcionarioSalvo);
    }
    
    @Transactional(readOnly = true)
    public List<FuncionarioDTO> buscarTodos() {
        return funcionarioRepository.findAll().stream()
                     .map(FuncionarioDTO::fromEntity)
                     .collect(Collectors.toList());
    }
    
    @Transactional(readOnly = true)
    public Optional<FuncionarioDTO> buscarPorId(Long id) {
        return funcionarioRepository.findById(id)
            .map(FuncionarioDTO::fromEntity); 
    }

    @Transactional
    public Optional<FuncionarioDTO> atualizar(FuncionarioDTO dto) {
        
        Optional<Funcionario> optionalFuncionario = funcionarioRepository.findById(dto.getId());

        if (optionalFuncionario.isEmpty()) {
            return Optional.empty();    
        }

        Funcionario funcionarioExistente = optionalFuncionario.get();
        
        funcionarioExistente.setNome(dto.getNome());
        funcionarioExistente.setEmail(dto.getEmail());
        funcionarioExistente.setSenha(dto.getSenha());
        
        Funcionario FuncionarioAtualizado = funcionarioRepository.save(funcionarioExistente);
        
        return Optional.of(FuncionarioDTO.fromEntity(FuncionarioAtualizado));
    }

    @Transactional
    public boolean deletar(Long id) {
        if (!funcionarioRepository.existsById(id)) {
             return false; 
        }
        funcionarioRepository.deleteById(id);
        return true;
    }
}
