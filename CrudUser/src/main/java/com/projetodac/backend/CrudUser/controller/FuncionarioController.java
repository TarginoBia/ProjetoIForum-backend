package com.projeto.IForum.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.IForum.dto.FuncionarioDTO;
import com.projeto.IForum.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController{
    private List<Funcionario> funcionarios = new ArrayList<>();

    @GetMapping("/funcionarios")
    public List<Funcionario> getAllFuncionarios() {
        return funcionarios;
    }

    @PostMapping("/funcionarios")
    public String addFuncionario(@RequestBody Funcionario funcionario) {
        funcionario.add(funcionario);
        return "Funcionário inserido com sucesso";
    }

    @PutMapping("/funcionarios/{id}")
    public String updateFuncionario(@PathVariable int id, @RequestBody Funcionario updatedFuncionario) {
        for (Funcionario funcionarios : funcionarios) {
            if (funcionarios.getId() == id) {
                funcionarios.setName(updatedfuncionarios.getName());
                return "Funcionário atualizado com sucesso";
            }
        }
        return "Funcionário não encontrado!";
    }

    @DeleteMapping("/funcionarios/{id}")
    public String deletefuncionarios(@PathVariable int id) {
        funcionarios.removeIf(funcionarios -> funcionarios.getId() == id);
        return "Funcionário deletado com sucesso";
    }
}
