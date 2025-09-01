package com.projetodac.backend.CrudUser.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.projetodac.backend.CrudUser.dto.AlunoDTO;
import com.projetodac.backend.CrudUser.interfaces.AlunoMapper;
import com.projetodac.backend.CrudUser.repository.AlunoRepository;

@Service
public class AlunoService {

    private final AlunoRepository repo;
    private final AlunoMapper alunoMapper;

    public AlunoService(AlunoRepository alunoRepository, AlunoMapper alunoMapper) {
        this.repo = alunoRepository;
        this.alunoMapper = alunoMapper;
    }

    @Transactional
    public AlunoDTO create(AlunoDTO dto) {
        if(!dto.getEmail().endsWith("@ifpb.edu.br")){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Apenas e-mails institucionais '@ifpb.edu.br' são permitidos.");
        }
        if (repo.existsByEmail(dto.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "E-mail já cadastrado");
        }
        var entity = alunoMapper.toAluno(dto);
        var saved = repo.save(entity);
        return alunoMapper.toAlunoDTO(saved);
    }

    @Transactional
    public AlunoDTO update(Long id, AlunoDTO dto) {
        var entity = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado"));

        entity.setMatricula(dto.getMatricula());
        entity.setEmail(dto.getEmail());
        entity.setName(dto.getNome());

        var saved = repo.save(entity);
        return alunoMapper.toAlunoDTO(saved);
    }

    @Transactional(readOnly = true)
    public List<AlunoDTO> findAll() {
        return repo.findAll().stream()
                .map(alunoMapper::toAlunoDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public AlunoDTO findById(Long id) {
        return repo.findById(id)
                .map(alunoMapper::toAlunoDTO)
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