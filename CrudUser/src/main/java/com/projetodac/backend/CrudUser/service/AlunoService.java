package com.projeto.IForum.service;

import com.projeto.IForum.dto.AlunoDTO;
import com.projeto.IForum.model.Aluno;
import com.projeto.IForum.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;
    
    @Autowired
    private UsuarioService usuarioService;
    
    public AlunoDTO create(AlunoDTO alunoDTO) {
        usuarioService.checkEmailUniqueness(alunoDTO.getEmail()); 
        
        Aluno aluno = new Aluno();
        aluno.setName(alunoDTO.getName());
        aluno.setEmail(alunoDTO.getEmail());        
        aluno.setMatricula(alunoDTO.getMatricula());
        
        aluno = alunoRepository.save(aluno);
        
        return new AlunoDTO(aluno);
    }
    
    public AlunoDTO findById(Long id) {
        Aluno aluno = alunoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Aluno não encontrado."));
            
        return new AlunoDTO(aluno);
    }
    
}