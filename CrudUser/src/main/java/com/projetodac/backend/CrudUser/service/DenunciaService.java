package com.projeto.IForum.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.IForum.dto.DenunciaDTO;
import com.projeto.IForum.enums.Status;
import com.projeto.IForum.model.Denuncia;
import com.projeto.IForum.model.Usuario;
import com.projeto.IForum.repository.DenunciaRepository;
import com.projeto.IForum.repository.UsuarioRepository;

@Service
public class DenunciaService {

    @Autowired
    private DenunciaRepository denunciaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository; 
    
    public DenunciaDTO registrarDenuncia(DenunciaDTO denunciaDTO) {
        Usuario autor = usuarioRepository.findById(denunciaDTO.getAutorId())
            .orElseThrow(() -> new RuntimeException("Autor da denúncia não encontrado."));
            
        Denuncia denuncia = new Denuncia();
        denuncia.setTitulo(denunciaDTO.getTitulo());
        denuncia.setConteudo(denunciaDTO.getConteudo());
        
        denuncia.setAutor(autor);
        denuncia.setDataCriacao(LocalDateTime.now());
        denuncia.setStatus(Status.ABERTA); 
        
        denuncia = denunciaRepository.save(denuncia);
        
        return new DenunciaDTO(denuncia);
    }
    
    public DenunciaDTO atualizarStatus(Long denunciaId, Status novoStatus) {
        Denuncia denuncia = denunciaRepository.findById(denunciaId)
            .orElseThrow(() -> new RuntimeException("Denúncia não encontrada."));
            
        denuncia.setStatus(novoStatus);
        denuncia = denunciaRepository.save(denuncia);
        
        return new DenunciaDTO(denuncia);
    }

}