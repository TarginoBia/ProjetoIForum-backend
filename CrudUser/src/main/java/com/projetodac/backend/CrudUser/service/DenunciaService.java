package com.projetodac.backend.CrudUser.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.projetodac.backend.CrudUser.dto.DenunciaDTO;
import com.projetodac.backend.CrudUser.enums.Status;
import com.projetodac.backend.CrudUser.interfaces.DenunciaMapper;
import com.projetodac.backend.CrudUser.model.Denuncia;
import com.projetodac.backend.CrudUser.repository.DenunciaRepository;

@Service
public class DenunciaService {

    private final DenunciaRepository repo;
    private final DenunciaMapper denunciaMapper;

    public DenunciaService(DenunciaRepository repo, DenunciaMapper denunciaMapper) {
        this.repo = repo;
        this.denunciaMapper = denunciaMapper;
    }

    @Transactional
    public DenunciaDTO create(DenunciaDTO dto) {
        var entity = denunciaMapper.toDenuncia(dto);
        var saved = repo.save(entity);
        return denunciaMapper.toDenunciaDto(saved);
    }

    @Transactional(readOnly = true)
    public List<DenunciaDTO> findAll() {
        return repo.findAll().stream()
                .map(denunciaMapper::toDenunciaDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public DenunciaDTO findById(Long id) {
        return repo.findById(id)
                .map(denunciaMapper::toDenunciaDto)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Denúncia não encontrada"));
    }

    @Transactional
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Denúncia não encontrada");
        }
        repo.deleteById(id);
    }

    @Transactional
    public DenunciaDTO atualizarStatus(Long id, Status novoStatus) {
        var denuncia = repo.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Denúncia não encontrada")
            );

        denuncia.setStatus(novoStatus);

        var saved = repo.save(denuncia);

        return toDTO(saved);
    }

    private DenunciaDTO toDTO(Denuncia entity) {
        DenunciaDTO dto = new DenunciaDTO(entity.getId(), entity.getTitulo(), entity.getDescricao(), entity.getStatus(),
                entity.getUsuario().getName(), entity.getUsuario().getEmail());
        return dto;
    }
}

