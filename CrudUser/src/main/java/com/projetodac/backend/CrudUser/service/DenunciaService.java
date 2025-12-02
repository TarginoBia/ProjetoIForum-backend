package com.projeto.IForum.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.IForum.dto.DenunciaDTO;
import com.projeto.IForum.model.Denuncia;
import com.projeto.IForum.repository.DenunciaRepository;

@Service
public class DenunciaService{

    private final DenunciaRepository denunciaRepository;
 
    public DenunciaService(DenunciaRepository denunciaRepository) {
        this.denunciaRepository = denunciaRepository;
    }

    @Transactional
    public DenunciaDTO salvar(DenunciaDTO dto) {
        Denuncia denuncia = DenunciaDTO.toEntity(dto);
        Denuncia denunciaSalvo = denunciaRepository.save(denuncia);
        return DenunciaDTO.fromEntity(denunciaSalvo);
    }
    
    @Transactional(readOnly = true)
    public List<DenunciaDTO> buscarTodos() {
        return denunciaRepository.findAll().stream()
                     .map(DenunciaDTO::fromEntity)
                     .collect(Collectors.toList());
    }
    
    @Transactional(readOnly = true)
    public Optional<DenunciaDTO> buscarPorId(Long id) {
        return denunciaRepository.findById(id)
            .map(DenunciaDTO::fromEntity); 
    }

    @Transactional
    public Optional<DenunciaDTO> atualizar(DenunciaDTO dto) {
        
        Optional<Denuncia> optionalDenuncia = denunciaRepository.findById(dto.getId());

        if (optionalDenuncia.isEmpty()) {
            return Optional.empty();    
        }

        Denuncia denunciaExistente = optionalDenuncia.get();
        
            denunciaExistente.setDescricao(dto.getDescricao());
            denunciaExistente.setTitulo(dto.getTitulo());
            denunciaExistente.setStatus(dto.getStatus());
        
        Denuncia denunciaAtualizado = denunciaRepository.save(denunciaExistente);
        
        return Optional.of(DenunciaDTO.fromEntity(denunciaAtualizado));
    }

    @Transactional
    public boolean deletar(Long id) {
        if (!denunciaRepository.existsById(id)) {
             return false; 
        }
        denunciaRepository.deleteById(id);
        return true;
    }
}
