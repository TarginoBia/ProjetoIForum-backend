package com.projeto.IForum.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.IForum.model.Denuncia;
import com.projeto.IForum.repository.DenunciaRepository;

@Service
public class DenunciaService{

    private final DenunciaRepository denunciaRepository;

    @Autowired 
    public DenunciaService(DenunciaRepository denunciaRepository) {
        this.denunciaRepository = denunciaRepository;
    }

    public Denuncia salvarDenuncia(Denuncia denuncia) {
        return denunciaRepository.save(denuncia);
    }

    public Optional<Denuncia> buscarPorId(Long id) {
        return denunciaRepository.findById(id);
    }

    public List<Denuncia> buscarTodos() {
        return denunciaRepository.findAll();
    }
    
    public void deletarDenuncia(Long id) {
        denunciaRepository.deleteById(id);
    }
}
