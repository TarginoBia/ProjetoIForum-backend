package com.projeto.IForum.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.IForum.dto.AlunoDTO;
import com.projeto.IForum.model.Aluno;
import com.projeto.IForum.repository.AlunoRepository;

@Service 
public class AlunoService {

    @Autowired 
    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    
    @Transactional
    public AlunoDTO salvar(AlunoDTO dto) {
        Aluno aluno = AlunoDTO.toEntity(dto);
        Aluno alunoSalvo = alunoRepository.save(aluno);
        return AlunoDTO.fromEntity(alunoSalvo);
    }
    
    @Transactional(readOnly = true)
    public List<AlunoDTO> buscarTodos() {
        return alunoRepository.findAll().stream()
                     .map(AlunoDTO::fromEntity)
                     .collect(Collectors.toList());
    }
    
    @Transactional(readOnly = true)
    public Optional<AlunoDTO> buscarPorId(Long id) {
        return alunoRepository.findById(id)
            .map(AlunoDTO::fromEntity); 
    }

    @Transactional
    public Optional<AlunoDTO> atualizar(AlunoDTO dto) {
        
        Optional<Aluno> optionalAluno = alunoRepository.findById(dto.getId());

        if (optionalAluno.isEmpty()) {
            return Optional.empty(); 
        }

        Aluno alunoExistente = optionalAluno.get();
        
        alunoExistente.setNome(dto.getNome());
        alunoExistente.setEmail(dto.getEmail());
        alunoExistente.setSenha(dto.getSenha());
        alunoExistente.setMatricula(dto.getMatricula());
        
        Aluno alunoAtualizado = alunoRepository.save(alunoExistente);
        
        return Optional.of(AlunoDTO.fromEntity(alunoAtualizado));
    }

    @Transactional
    public boolean deletar(Long id) {
        if (!alunoRepository.existsById(id)) {
             return false; 
        }
        alunoRepository.deleteById(id);
        return true;
    }
}
