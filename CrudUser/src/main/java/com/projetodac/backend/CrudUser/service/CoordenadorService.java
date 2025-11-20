package com.projeto.IForum.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.IForum.model.Coordenador;
import com.projeto.IForum.repository.CoordenadorRepository;

@Service
public class CoordenadorService{

    private final CoordenadorRepository coordenadorRepository;

    @Autowired 
    public CoordenadorService(CoordenadorRepository coordenadorRepository) {
        this.coordenadorRepository = coordenadorRepository;
    }

    public Coordenador salvarCoordenador(Coordenador coordenador) {
        if (coordenador.getEmail() == null || coordenador.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email é obrigatório.");
        }
        return coordenadorRepository.save(coordenador);
    }

    public Optional<Coordenador> buscarPorId(Long id) {
        return coordenadorRepository.findById(id);
    }

    public List<Coordenador> buscarTodos() {
        return coordenadorRepository.findAll();
    }
    
    public void deletarCoordenador(Long id) {
        coordenadorRepository.deleteById(id);
    }
}
