package com.projetodac.backend.CrudUser.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.projetodac.backend.CrudUser.dto.FuncionarioDTO;
import com.projetodac.backend.CrudUser.interfaces.FuncionarioMapper;
import com.projetodac.backend.CrudUser.repository.FuncionarioRepository;

@Service
public class FuncionarioService{

    private final FuncionarioRepository repo;
    private final FuncionarioMapper funcionarioMapper;

    public FuncionarioService(FuncionarioRepository repo, FuncionarioMapper funcionarioMapper) {
        this.repo = repo;
        this.funcionarioMapper = funcionarioMapper;
    }

    @Transactional
    public FuncionarioDTO create(FuncionarioDTO dto) {
        if(!dto.getEmail().endsWith("@ifpb.edu.br")){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Apenas e-mails institucionais '@ifpb.edu.br' são permitidos.");
        }
        if (repo.existsByEmail(dto.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "E-mail já cadastrado");
        }
        var entity = funcionarioMapper.toFuncionario(dto);
        var saved = repo.save(entity);
        return funcionarioMapper.toFuncionarioDTO(saved);
    }

    @Transactional
    public FuncionarioDTO update(Long id, FuncionarioDTO dto) {
        var entity = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado"));
        
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        
        var saved = repo.save(entity);
        return funcionarioMapper.toFuncionarioDTO(saved);
    }

    @Transactional(readOnly = true)
    public List<FuncionarioDTO> findAll() {
        return repo.findAll().stream()
                .map(funcionarioMapper::toFuncionarioDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public FuncionarioDTO findById(Long id) {
        return repo.findById(id)
                .map(funcionarioMapper::toFuncionarioDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado"));
    }

    @Transactional
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado");
        }
        repo.deleteById(id);
    }
}
