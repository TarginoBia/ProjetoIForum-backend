package com.projeto.IForum.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.IForum.dto.CoordenadorDTO;
import com.projeto.IForum.model.Coordenador;
import com.projeto.IForum.repository.CoordenadorRepository;

@Service
public class CoordenadorService{

    private final CoordenadorRepository coordenadorRepository;
 
    public CoordenadorService(CoordenadorRepository coordenadorRepository) {
        this.coordenadorRepository = coordenadorRepository;
    }

    @Transactional
    public CoordenadorDTO salvar(CoordenadorDTO dto) {
        Coordenador coordenador = CoordenadorDTO.toEntity(dto);
        Coordenador coordenadorSalvo = coordenadorRepository.save(coordenador);
        return CoordenadorDTO.fromEntity(coordenadorSalvo);
    }
    
    @Transactional(readOnly = true)
    public List<CoordenadorDTO> buscarTodos() {
        return coordenadorRepository.findAll().stream()
                     .map(CoordenadorDTO::fromEntity)
                     .collect(Collectors.toList());
    }
    
    @Transactional(readOnly = true)
    public Optional<CoordenadorDTO> buscarPorId(Long id) {
        return coordenadorRepository.findById(id)
            .map(CoordenadorDTO::fromEntity); 
    }

    @Transactional
    public Optional<CoordenadorDTO> atualizar(CoordenadorDTO dto) {
        
        Optional<Coordenador> optionalCoordenador = coordenadorRepository.findById(dto.getId());

        if (optionalCoordenador.isEmpty()) {
            return Optional.empty();    
        }

        Coordenador CoordenadorExistente = optionalCoordenador.get();
        
        CoordenadorExistente.setNome(dto.getNome());
        CoordenadorExistente.setEmail(dto.getEmail());
        CoordenadorExistente.setSenha(dto.getSenha());
        
        Coordenador CoordenadorAtualizado = coordenadorRepository.save(CoordenadorExistente);
        
        return Optional.of(CoordenadorDTO.fromEntity(CoordenadorAtualizado));
    }

    @Transactional
    public boolean deletar(Long id) {
        if (!coordenadorRepository.existsById(id)) {
             return false; 
        }
        coordenadorRepository.deleteById(id);
        return true;
    }
}
