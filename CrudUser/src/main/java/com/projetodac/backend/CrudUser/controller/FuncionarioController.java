package com.projeto.IForum.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.IForum.dto.FuncionarioDTO;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController{

    @PostMapping
    public ResponseEntity<FuncionarioDTO> registrarFuncionario(@RequestBody FuncionarioDTO FuncionarioDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(FuncionarioDTO); 
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> buscarFuncionario(@PathVariable Long id) {
        return ResponseEntity.ok(new FuncionarioDTO()); 
    }

    @GetMapping
    public ResponseEntity<List<FuncionarioDTO>> listarFuncionarios() {
        return ResponseEntity.ok(Collections.emptyList()); 
    }
    
    @PutMapping("/{id}/status")
    public ResponseEntity<FuncionarioDTO> atualizarFuncionario(@PathVariable Long id, @RequestParam String novoStatus) {
        return ResponseEntity.ok(new FuncionarioDTO());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> deleteFuncionario(@PathVariable("id") Long id){
        return ResponseEntity.ok("Funcionário deletado com sucesso!.");
    }
}
