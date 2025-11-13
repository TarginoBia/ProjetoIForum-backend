package com.projeto.IForum.service;

import com.projeto.IForum.dto.CoordenadorDTO;
import com.projeto.IForum.model.Coordenador;
import com.projeto.IForum.repository.CoordenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoordenadorService {

    @Autowired
    private CoordenadorRepository coordenadorRepository;
    
    @Autowired
    private UsuarioService usuarioService;

    public CoordenadorDTO create(CoordenadorDTO coordenadorDTO) {
        usuarioService.checkEmailUniqueness(coordenadorDTO.getEmail());
        
        Coordenador coordenador = new Coordenador();
        coordenador.setName(coordenadorDTO.getName());
        coordenador.setEmail(coordenadorDTO.getEmail());
        coordenador.setSenha(coordenadorDTO.getSenha()); // Placeholder
        coordenador.setDepartamento(coordenadorDTO.getDepartamento());
        
        coordenador = coordenadorRepository.save(coordenador);
        
        return new CoordenadorDTO(coordenador);
    }
    
}