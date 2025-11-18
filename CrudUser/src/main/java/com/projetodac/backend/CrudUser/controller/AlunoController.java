package com.projeto.IForum.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.IForum.dto.AlunoDTO;
import com.projeto.IForum.service.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController{
    private List<Aluno> alunos = new ArrayList<>();

    @GetMapping("/alunos")
    public List<Aluno> getAllAlunos() {
        return alunos;
    }

    @PostMapping("/alunos")
    public String addAluno(@RequestBody Aluno alunos) {
        alunos.add(alunos);
        return "Aluno inserido com sucesso";
    }

    @PutMapping("/alunos/{id}")
    public String updateAluno(@PathVariable int id, @RequestBody Aluno updatedAluno) {
        for (Aluno alunos : alunos) {
            if (alunos.getId() == id) {
                alunos.setName(updatedAlunos.getName());
                return "Aluno atualizado com sucesso";
            }
        }
        return "Aluno não encontrado!";
    }

    @DeleteMapping("/alunos/{id}")
    public String deleteAlunos(@PathVariable int id) {
        alunos.removeIf(alunos -> alunos.getId() == id);
        return "Aluno deletado com sucesso";
    }
}
