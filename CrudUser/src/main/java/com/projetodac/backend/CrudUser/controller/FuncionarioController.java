package com.projeto.IForum.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.IForum.dto.FuncionarioDTO;
import com.projeto.IForum.service.FuncionarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/funcionarios")
public class FuncionarioController{
    
    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping
    public ResponseEntity<FuncionarioDTO> registrarFuncionario(@RequestBody FuncionarioDTO funcionarioDTO) {
        FuncionarioDTO novoFuncionario = funcionarioService.salvar(funcionarioDTO);
        return new ResponseEntity<>(novoFuncionario, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FuncionarioDTO>> listarFuncionarios() {
        List<FuncionarioDTO> listaFuncionarios = funcionarioService.buscarTodos();
        return ResponseEntity.ok(listaFuncionarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> buscarFuncionarioPorId(@PathVariable Long id) {
        Optional<FuncionarioDTO> funcionarioDTO = funcionarioService.buscarPorId(id);

        return funcionarioDTO.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> atualizarFuncionario(
            @PathVariable Long id,
            @Valid @RequestBody FuncionarioDTO funcionarioDTO
    ) {
        funcionarioDTO.setId(id);
        
        Optional<FuncionarioDTO> funcionarioAtualizado = funcionarioService.atualizar(funcionarioDTO);

        return funcionarioAtualizado.map(ResponseEntity::ok)
                              .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFuncionario(@PathVariable Long id) {
        boolean deletado = funcionarioService.deletar(id);

        if (deletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
