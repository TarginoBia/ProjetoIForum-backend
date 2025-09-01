package com.projetodac.backend.CrudUser.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.projetodac.backend.CrudUser.dto.CoordenadorDTO;
import com.projetodac.backend.CrudUser.interfaces.CoordenadorMapper;
import com.projetodac.backend.CrudUser.repository.CoordenadorRepository;

@Service
public class CoordenadorService{
    private final CoordenadorRepository repo;
    private final CoordenadorMapper coordenadorMapper;

    public CoordenadorService(CoordenadorRepository coordenadorRepository, CoordenadorMapper coordenadorMapper) {
        this.repo = coordenadorRepository;
        this.coordenadorMapper = coordenadorMapper;
    }

    @Transactional
    public CoordenadorDTO create(CoordenadorDTO dto) {
        if (!dto.getEmail().endsWith("@ifpb.edu.br")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Apenas e-mails institucionais '@ifpb.edu.br' são permitidos.");
        }
        if (repo.existsByEmail(dto.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "E-mail já cadastrado");
        }
        var entity = coordenadorMapper.toCoordenador(dto);
        var saved = repo.save(entity);
        return coordenadorMapper.toCoordenadorDTO(saved);
    }

    @Transactional
    public CoordenadorDTO update(Long id, CoordenadorDTO dto) {
        var entity = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Coordenador não encontrado"));

        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());

        var saved = repo.save(entity);
        return coordenadorMapper.toCoordenadorDTO(saved);
    }

    @Transactional(readOnly = true)
    public List<CoordenadorDTO> findAll() {
        return repo.findAll().stream()
                .map(coordenadorMapper::toCoordenadorDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CoordenadorDTO findById(Long id) {
        return repo.findById(id)
                .map(coordenadorMapper::toCoordenadorDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Coordenador não encontrado"));
    }

    @Transactional
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Coordenador não encontrado");
        }
        repo.deleteById(id);
    }
    
}
