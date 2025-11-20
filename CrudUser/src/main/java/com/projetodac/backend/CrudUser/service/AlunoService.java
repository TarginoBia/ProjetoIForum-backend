package com.projeto.IForum.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.IForum.model.Aluno;
import com.projeto.IForum.repository.AlunoRepository;

@Service 
public class AlunoService {

    private final AlunoRepository alunoRepository;

    @Autowired 
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Aluno salvarAluno(Aluno aluno) {
        if (aluno.getEmail() == null || aluno.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email é obrigatório.");
        }
        return alunoRepository.save(aluno);
    }

    public Optional<Aluno> buscarPorId(Long id) {
        return alunoRepository.findById(id);
    }

    public List<Aluno> buscarTodos() {
        return alunoRepository.findAll();
    }
    
    public void deletarAluno(Long id) {
        alunoRepository.deleteById(id);
    }
}
